package com.wy.integration.core;


import com.wy.integration.utils.support.DaoSupports;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void existIdIsNull(Object obj){
        DaoSupports.existIdIsNull(obj);
    }

    public int save(T model) {
        DaoSupports.addProperty(model);
        return mapper.insertSelective(model);
    }

    public int deleteBy(T model) {
        DaoSupports.deleteProperty(model);
        return mapper.updateByPrimaryKeySelective(model);
    } //适用于逻辑删除

    public int save(List<T> models) {
        models.forEach(t-> DaoSupports.addProperty(t));
        return mapper.insertList(models);
    }//批量插入

    public int deleteById(String id) {
        return mapper.deleteByPrimaryKey(id);
    }//适用于物理删除

    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    public int update(T model) {
        DaoSupports.updateProperty(model);
        return mapper.updateByPrimaryKeySelective(model);
    }

    public T findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {

        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }
}
