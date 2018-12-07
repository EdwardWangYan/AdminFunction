package com.wy.integration.service.impl;

import com.wy.integration.dao.SysPermissionMapper;
import com.wy.integration.dto.AddDeatilsUpdate.SysPermissionAddUpdateDto;
import com.wy.integration.dto.AddDeatilsUpdate.SysResourceAddUpdateDto;
import com.wy.integration.model.SysPermission;
import com.wy.integration.service.SysPermissionService;
import com.wy.integration.core.AbstractService;
import com.wy.integration.utils.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysPermissionServiceImpl extends BaseService<SysPermission> implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Integer addPermission(SysPermissionAddUpdateDto permissionDto) {
        SysPermission perssion=verifyCreateEntity(permissionDto);//验证名称是否重复
        return save(perssion);
    }

    /**
     * 验证资源名称是否重复
     * **/
    private SysPermission verifyCreateEntity(SysPermissionAddUpdateDto dto){
        throwIfExistAccount("permissionName",dto.getPermissionName());
        return (SysPermission)ToolUtil.copyProperties(dto,SysPermission.class);
    }

}
