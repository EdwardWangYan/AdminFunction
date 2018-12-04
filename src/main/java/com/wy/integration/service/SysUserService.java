package com.wy.integration.service;
import com.github.pagehelper.PageInfo;
import com.wy.integration.dto.OperatorLoginDto;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.dto.contion.SysUserContionDto;
import com.wy.integration.dto.returnlist.SysUserLoginSucessDto;
import com.wy.integration.model.SysUser;
import com.wy.integration.core.Service;


/**
 * Created by Edward on 2018/06/26.
 */
public interface SysUserService extends Service<SysUser> {

    /**
     * 用于系统后台新增用户
     * **/
    public int add(SysUserAddDto userAddDto);

    /**
     * 新增机构的时候  初始化机构用户
     * **/
    public int initOrgUser(SysUser sysUser);

    /**
     * 用于系统后台更新用户信息
     * **/
    public int updateUser(SysUserAddDto userAddDto);
    /**
     * 根据条件  查找用户
     * **/
    public PageInfo findByContion(SysUserContionDto dto);//逻辑删除
    /**
     * 用户登陆
     * **/
    public SysUserLoginSucessDto login(OperatorLoginDto dto);
}
