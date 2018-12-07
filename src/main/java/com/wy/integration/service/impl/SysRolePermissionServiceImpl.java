package com.wy.integration.service.impl;

import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dao.SysRolePermissionMapper;
import com.wy.integration.dto.AddDeatilsUpdate.RolePerMissIonDto;
import com.wy.integration.model.SysRolePermission;
import com.wy.integration.service.SysRolePermissionService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysRolePermissionServiceImpl extends BaseService<SysRolePermission> implements SysRolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 给角色分配权限
     * **/
    @Override
    public void initRollePermission(String roleId, List<RolePerMissIonDto> permissoinId) {
       if(permissoinId!=null&&permissoinId.size()> ConstantsFlag.FLAG.ZERO.getValue())
           save(permissoinId.stream().map(s->{
               SysRolePermission permission=new SysRolePermission();
               permission.setRoleId(roleId);
               permission.setPermissionId(s.getId());
               return permission;
           }).collect(Collectors.toList()));
    }
}
