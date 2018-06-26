package com.wy.integration.service;
import com.github.pagehelper.PageInfo;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.dto.contion.SysUserContionDto;
import com.wy.integration.model.SysUser;
import com.wy.integration.core.Service;


/**
 * Created by Edward on 2018/06/26.
 */
public interface SysUserService extends Service<SysUser> {

    public int add(SysUserAddDto userAddDto);

    public int updateUser(SysUserAddDto userAddDto);

    public int deleteBy(String id);//逻辑删除

    public PageInfo findByContion(SysUserContionDto dto);//逻辑删除

}
