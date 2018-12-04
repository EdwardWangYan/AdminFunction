package com.wy.integration.service.impl;

import com.wy.integration.dao.SysRoleInfoMapper;
import com.wy.integration.model.SysRoleInfo;
import com.wy.integration.service.SysRoleInfoService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysRoleInfoServiceImpl extends AbstractService<SysRoleInfo> implements SysRoleInfoService {
    @Resource
    private SysRoleInfoMapper sysRoleInfoMapper;

}
