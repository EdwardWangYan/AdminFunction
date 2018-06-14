package com.wy.integration.service.impl;

import com.wy.integration.dao.SysRoleMapper;
import com.wy.integration.model.SysRole;
import com.wy.integration.service.SysRoleService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/06/10.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

}
