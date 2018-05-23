package com.wy.integration.service.impl;

import com.wy.integration.dao.TUserMapper;
import com.wy.integration.model.TUser;
import com.wy.integration.service.TUserService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/05/23.
 */
@Service
@Transactional
public class TUserServiceImpl extends AbstractService<TUser> implements TUserService {
    @Resource
    private TUserMapper tUserMapper;

}
