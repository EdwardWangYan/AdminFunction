package com.wy.integration.service.impl;

import com.wy.integration.dao.SysRolePermissionMapper;
import com.wy.integration.model.SysRolePermission;
import com.wy.integration.service.SysRolePermissionService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysRolePermissionServiceImpl extends AbstractService<SysRolePermission> implements SysRolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

}
