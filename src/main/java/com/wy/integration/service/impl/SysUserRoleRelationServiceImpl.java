package com.wy.integration.service.impl;

import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dao.SysUserRoleRelationMapper;
import com.wy.integration.dto.AddDeatilsUpdate.UserRoleDto;
import com.wy.integration.model.SysUserRoleRelation;
import com.wy.integration.service.SysUserRoleRelationService;
import com.wy.integration.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysUserRoleRelationServiceImpl extends BaseService<SysUserRoleRelation> implements SysUserRoleRelationService {
    @Resource
    private SysUserRoleRelationMapper sysUserRoleRelationMapper;

    /**
     * 用户分配角色
     * **/
    @Override
    public void initUserRole(String userId, List<UserRoleDto> roleIdList) {
        if(roleIdList!=null&&roleIdList.size()> ConstantsFlag.FLAG.ZERO.getValue())
            save(roleIdList.stream().map(s->{
                SysUserRoleRelation permission=new SysUserRoleRelation();
                permission.setUserId(userId);
                permission.setRoleId(s.getId());
                return permission;
            }).collect(Collectors.toList()));
    }
}
