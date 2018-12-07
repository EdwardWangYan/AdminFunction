package com.wy.integration.service;
import com.wy.integration.dto.AddDeatilsUpdate.UserRoleDto;
import com.wy.integration.model.SysUserRoleRelation;
import com.wy.integration.core.Service;

import java.util.List;


/**
 * Created by Edward on 2018/12/04.
 */
public interface SysUserRoleRelationService extends Service<SysUserRoleRelation> {

    /**
     * 用户分配角色
     * */
    public void initUserRole(String userId, List<UserRoleDto> roleIdList);

}
