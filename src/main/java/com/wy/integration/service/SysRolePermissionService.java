package com.wy.integration.service;
import com.wy.integration.dto.AddDeatilsUpdate.RolePerMissIonDto;
import com.wy.integration.model.SysRolePermission;
import com.wy.integration.core.Service;

import java.util.List;


/**
 * Created by Edward on 2018/12/04.
 */
public interface SysRolePermissionService extends Service<SysRolePermission> {

    /**
     *后台初始化关联角色权限
     *
     * 给角色分配权限
     *
     ***/
    public  void  initRollePermission(String roleId,List<RolePerMissIonDto> permissoinIdList);
}
