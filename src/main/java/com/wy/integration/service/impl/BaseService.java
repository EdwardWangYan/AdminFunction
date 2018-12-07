package com.wy.integration.service.impl;

import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.core.AbstractService;
import com.wy.integration.core.Mapper;
import com.wy.integration.core.Service;
import com.wy.integration.core.ServiceException;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.utils.ToolUtil;
import com.wy.integration.utils.support.DaoSupports;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

/**
 * 加多一层 过滤层  用于其他的功能  添加当前创建者的机构主键
 * **/
public abstract class BaseService<T>  implements Service<T> {
    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class



    public BaseService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }



    public int save(T model) {
        DaoSupports.addOrgId(model);//先给功能 添加当前登陆用户的机构主键
        DaoSupports.addProperty(model);
        return mapper.insertSelective(model);
    }




    public int deleteBy(String id) {
        T model= this.findByIdDel(id);
        DaoSupports.deleteProperty(model);
        return mapper.updateByPrimaryKeySelective(model);
    } //适用于逻辑删除

    public int save(List<T> models) {
        models.forEach(t-> {
            DaoSupports.addOrgId(t);
            DaoSupports.addProperty(t);
        });
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

    //用户查找逻辑删除
    public T findByIdDel(String id){
        T model=this.newEntityInstance();
        DaoSupports.findById(model,id);
        T entity=mapper.selectOne(model);
        DaoSupports.entityIsNotNoll(entity);
        return entity;
    }

    public T findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    protected T newEntityInstance() {
        try {
            return  modelClass.newInstance();
        } catch (Exception var2) {
            var2.printStackTrace();
            throw new RuntimeException(var2);
        }
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model=this.newEntityInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public T findByListFieldName(List<String> fieldNameList, List<Object> valueList) throws TooManyResultsException {
        try {
            T model = this.newEntityInstance();
            for (int i = 0; i < fieldNameList.size(); i++) {
                String fieldName = fieldNameList.get(i);
                Object value = valueList.get(i);
                Field field = modelClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(model, value);
            }
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    //逻辑删除 走此接口
    public List<T> findByConditionDel(Condition conditio, Example.Criteria createCriteria){
        createCriteria.andEqualTo("delFlag", ConstantsFlag.IsDeleteFlag.NotDeleted.getValue());
        createCriteria.andEqualTo("orgId",DaoSupports.getOrgId());
        return this.findByCondition(conditio);
    }

    //物理删除  走此接口
    public List<T> findByCondition(Condition condition) {
        condition.setOrderByClause("create_date DESC");
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }


    /**
     * 验证名称是否重复
     */
    protected boolean existName(List<String> fieldNameList, List<Object> valueList) {
        return  findByListFieldName(fieldNameList,valueList)!=null;
        }




    /**
     * 验证名称是否重复  同一机构下的比较
     */
    protected void throwIfExistAccount(String fieldName,String roleName) {
        if (existName(  Arrays.asList("orgId",fieldName),Arrays.asList(  DaoSupports.getOrgId(),roleName)))
                throw new ResponseException(CMMErrorCode.ENTITY_IS_EXIST);
        }

}
