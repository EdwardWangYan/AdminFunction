package com.wy.integration.service.impl;

import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dao.SysRoleResourceMapper;
import com.wy.integration.dto.AddDeatilsUpdate.Resource.RoleResourceDto;
import com.wy.integration.model.SysRoleResource;
import com.wy.integration.service.SysRoleResourceService;
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
public class SysRoleResourceServiceImpl extends BaseService<SysRoleResource> implements SysRoleResourceService {
    @Resource
    private SysRoleResourceMapper sysRoleResourceMapper;

    /**
     * 给角色分配资源
     * **/
    @Override
    public void initRolleResource(String roleId, List<RoleResourceDto> resourceIdList) {
        if(resourceIdList!=null&&resourceIdList.size()> ConstantsFlag.FLAG.ZERO.getValue())
            save(resourceIdList.stream().map(s->{
                SysRoleResource permission=new SysRoleResource();
                permission.setRoleId(roleId);
                permission.setResourceId(s.getId());
                return permission;
            }).collect(Collectors.toList()));
    }
}
