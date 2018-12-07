package com.wy.integration.service;
import com.wy.integration.dto.AddDeatilsUpdate.Resource.RoleResourceDto;
import com.wy.integration.model.SysRoleResource;
import com.wy.integration.core.Service;

import java.util.List;


/**
 * Created by Edward on 2018/12/04.
 */
public interface SysRoleResourceService extends Service<SysRoleResource> {
    /**
     *后台初始化关联角色资源
     * 给角色分配资源
     **/
    public  void  initRolleResource(String roleId,List<RoleResourceDto>resourceIdList);
}
