package com.wy.integration.service.impl;

import com.wy.integration.dao.SysResourceMapper;
import com.wy.integration.model.SysResource;
import com.wy.integration.service.SysResourceService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysResourceServiceImpl extends AbstractService<SysResource> implements SysResourceService {
    @Resource
    private SysResourceMapper sysResourceMapper;

}
