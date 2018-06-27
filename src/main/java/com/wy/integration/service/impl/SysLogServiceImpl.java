package com.wy.integration.service.impl;

import com.wy.integration.dao.SysLogMapper;
import com.wy.integration.model.SysLog;
import com.wy.integration.service.SysLogService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/06/26.
 */
@Service
@Transactional
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

}
