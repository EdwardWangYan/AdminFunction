package com.wy.integration.service.impl;

import com.wy.integration.dao.SysGroupMapper;
import com.wy.integration.model.SysGroup;
import com.wy.integration.service.SysGroupService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/06/10.
 */
@Service
@Transactional
public class SysGroupServiceImpl extends AbstractService<SysGroup> implements SysGroupService {
    @Resource
    private SysGroupMapper sysGroupMapper;

}
