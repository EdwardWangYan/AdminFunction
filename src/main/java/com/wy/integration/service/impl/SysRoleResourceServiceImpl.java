package com.wy.integration.service.impl;

import com.wy.integration.dao.SysRoleResourceMapper;
import com.wy.integration.model.SysRoleResource;
import com.wy.integration.service.SysRoleResourceService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysRoleResourceServiceImpl extends AbstractService<SysRoleResource> implements SysRoleResourceService {
    @Resource
    private SysRoleResourceMapper sysRoleResourceMapper;

}
