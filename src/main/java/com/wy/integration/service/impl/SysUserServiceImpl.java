package com.wy.integration.service.impl;

import com.wy.integration.dao.SysUserMapper;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserService;
import com.wy.integration.core.AbstractService;
import com.wy.integration.utils.ToolUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


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
        if (existTitle(title)==null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }



    //验证用户邮箱是否重复
    protected void throwIfExistEmail(String email) {
        if (existEmail(email)==null) {
            throw new ResponseException(CMMErrorCode.USER_TITLE_IS_EXISTS);
        }
    }
    //验证用户邮箱是否重复
    public SysUser existEmail(String email) {
        return findBy("email",email);
    }
    //验证用户手机是否重复
    protected void throwIfExistTel(String tel) {
        if (existTel(tel)==null) {
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
    public int save(SysUserAddDto userAddDto) {
        SysUser sysUser= verifyCreateDto(userAddDto);
        ToolUtil.entryptPassword(sysUser);
        return save(sysUser);
    }

}
