package com.wy.integration.service.impl;

import com.wy.integration.dao.SysUserMapper;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysUserService;
import com.wy.integration.core.AbstractService;
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
     * 验证商品名称是否重复
     */
    protected SysUser existTitle(String loginName) {
        return findBy("loginName",loginName);
    }

    protected void throwIfExistAccount(String title) {
        if (existTitle(title)==null) {

        }
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



        return 0;
    }

}
