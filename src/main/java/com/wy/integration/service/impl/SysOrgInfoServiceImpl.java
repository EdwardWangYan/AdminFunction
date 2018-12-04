package com.wy.integration.service.impl;

import com.wy.integration.dao.SysOrgInfoMapper;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.model.SysOrgInfo;
import com.wy.integration.model.SysUser;
import com.wy.integration.service.SysOrgInfoService;
import com.wy.integration.core.AbstractService;
import com.wy.integration.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysOrgInfoServiceImpl extends AbstractService<SysOrgInfo> implements SysOrgInfoService {
    @Resource
    private SysOrgInfoMapper sysOrgInfoMapper;


    @Autowired
    private SysUserService sysUserService;
    /**
     * 验证机构名称是否重复
     */
    public SysOrgInfo existTitle(String title) {
        return findBy("title",title);
    }


    /**
     * 验证机构名称是否重复
     */
    protected void throwIfExistAccount(String title) {
        if (existTitle(title)!=null) {
            throw new ResponseException(CMMErrorCode.ORG_TITLE_IS_EXISTS);
        }
    }

    @Override
    public int addOrg(SysOrgInfo orgInfo) {
        throwIfExistAccount(orgInfo.getTitle());
        int org=save(orgInfo);
        initOrgUser(orgInfo);
        return org;
    }


    /**
     * 新增机构的时候  初始化机构用户
     * 机构名称+admin
     * 密码 123456
     * **/
    private void initOrgUser(SysOrgInfo orgInfo){
        SysUser user=new SysUser();
        user.setOrgId(orgInfo.getId());
        user.setLoginName(orgInfo.getTitle()+"admin");
        user.setPassword("123456");
        user.setTel(orgInfo.getTelephone());
        sysUserService.initOrgUser(user);
    }

    @Override
    public int updateOrg(SysOrgInfo userAddDto) {
        return 0;
    }
}
