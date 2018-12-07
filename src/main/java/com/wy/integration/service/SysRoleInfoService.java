package com.wy.integration.service;
import com.wy.integration.dto.AddDeatilsUpdate.SysRoleAddUpdateDto;
import com.wy.integration.model.SysRoleInfo;
import com.wy.integration.core.Service;


/**
 * Created by Edward on 2018/12/04.
 */
public interface SysRoleInfoService extends Service<SysRoleInfo> {

    public  Integer addRole(SysRoleAddUpdateDto role);

}
