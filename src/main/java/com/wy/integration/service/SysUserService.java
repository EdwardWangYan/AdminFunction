package com.wy.integration.service;
import com.wy.integration.dto.SysUserAddDto;
import com.wy.integration.model.SysUser;
import com.wy.integration.core.Service;


/**
 * Created by Edward on 2018/06/10.
 */
public interface SysUserService extends Service<SysUser> {
    int save(SysUserAddDto userAddDto);

}
