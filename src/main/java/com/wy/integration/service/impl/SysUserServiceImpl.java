package com.wy.integration.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dao.SysUserMapper;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.dto.contion.SysUserContionDto;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserService;
import com.wy.integration.core.AbstractService;
import com.wy.integration.utils.ToolUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Edward on 2018/06/10.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 验证商品名称是否重复
     */

    /**
     * 验证用户登录名是否重复
     */
    public SysUser existTitle(String loginName) {
        return findBy("loginName",loginName);
    }
    //验证用户登录名是否重复
    protected void throwIfExistAccount(String title) {
        if (existTitle(title)!=null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }



    //验证用户邮箱是否重复
    protected void throwIfExistEmail(String email) {
        if (existEmail(email)!=null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }
    //验证用户邮箱是否重复
    public SysUser existEmail(String email) {
        return findBy("email",email);
    }
    //验证用户手机是否重复
    protected void throwIfExistTel(String tel) {
        if (existTel(tel)!=null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }

    //验证用户手机是否重复
    public SysUser existTel(String tel) {
        return findBy("tel",tel);
    }

    /**
     * 验证商品是否重复  转化实体和模型
     */

    private SysUser verifyCreateDto(SysUserAddDto dto) {
        throwIfExistAccount(dto.getLoginName());
        SysUser sysUser=new SysUser();
        BeanUtils.copyProperties(dto, sysUser);
        return sysUser;
    }


    @Override
    public int add(SysUserAddDto userAddDto) {
        SysUser sysUser= verifyCreateDto(userAddDto);
        ToolUtil.entryptPassword(sysUser);
        return save(sysUser);
    }

    /**
     * 验证用户是否存在
     */
    private SysUser  existUser(String id){
        SysUser user=findById(id);
        if(user==null)  throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        return user;

    }

    //根据模型  做更新前准备
    private SysUser getUser(SysUserAddDto userAddDto){
        existIdIsNull(userAddDto);//判断模型内的主键不为空
        existUser(userAddDto.getId());
        //更新用户
        SysUser sysUser=new SysUser();
        BeanUtils.copyProperties(userAddDto, sysUser);
        return sysUser;
    }


    //更新用户操作
    @Override
    public int updateUser(SysUserAddDto userAddDto) {
        SysUser sysUser= getUser(userAddDto);
        ToolUtil.entryptPassword(sysUser);
        return save(sysUser);
    }


    //删除用户 走逻辑删除

    @Override
    public int deleteBy(String id) {
        SysUser user=existUser(id);
        return deleteBy(user);
    }

    @Override
    public PageInfo findByContion(SysUserContionDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        Condition condition=new Condition(SysUser.class);
        Example.Criteria createCriteria=condition.createCriteria();
        if(StringUtils.isNoneBlank(dto.getLoginNameOrEmail())){
            createCriteria.andLike("loginName","%" + StringUtils.trim(dto.getLoginNameOrEmail()) + "%");
            createCriteria.orLike("email","%" + StringUtils.trim(dto.getLoginNameOrEmail()) + "%");
        }
        createCriteria.andEqualTo("delFlag", ConstantsFlag.IsDeleteFlag.NotDeleted.getValue());
        condition.setOrderByClause("create_date DESC");
        List<SysUser> userList=findByCondition(condition);
        return   new PageInfo(userList);
    }

}
