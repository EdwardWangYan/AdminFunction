package com.wy.integration.service.impl;

import com.wy.integration.dao.SysUserRoleRelationMapper;
import com.wy.integration.model.SysUserRoleRelation;
import com.wy.integration.service.SysUserRoleRelationService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysUserRoleRelationServiceImpl extends AbstractService<SysUserRoleRelation> implements SysUserRoleRelationService {
    @Resource
    private SysUserRoleRelationMapper sysUserRoleRelationMapper;

}
