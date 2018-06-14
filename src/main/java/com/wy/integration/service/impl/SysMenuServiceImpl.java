package com.wy.integration.service.impl;

import com.wy.integration.dao.SysMenuMapper;
import com.wy.integration.model.SysMenu;
import com.wy.integration.service.SysMenuService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/06/10.
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

}
