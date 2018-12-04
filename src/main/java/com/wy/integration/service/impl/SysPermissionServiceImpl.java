package com.wy.integration.service.impl;

import com.wy.integration.dao.SysPermissionMapper;
import com.wy.integration.model.SysPermission;
import com.wy.integration.service.SysPermissionService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysPermissionServiceImpl extends AbstractService<SysPermission> implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

}
