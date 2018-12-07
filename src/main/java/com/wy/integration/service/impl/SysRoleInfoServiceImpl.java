package com.wy.integration.service.impl;

import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dao.SysRoleInfoMapper;
import com.wy.integration.dto.AddDeatilsUpdate.SysRoleAddUpdateDto;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.model.SysRoleInfo;
import com.wy.integration.service.SysRoleInfoService;
import com.wy.integration.core.AbstractService;
import com.wy.integration.service.SysRolePermissionService;
import com.wy.integration.service.SysRoleResourceService;
import com.wy.integration.utils.Constants;
import com.wy.integration.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysRoleInfoServiceImpl extends BaseService<SysRoleInfo> implements SysRoleInfoService {
    @Resource
    private SysRoleInfoMapper sysRoleInfoMapper;
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Autowired
    private SysRoleResourceService sysRoleResourceService;


   /**
    * 验证角色名称是否重复
    * **/
    private SysRoleInfo verifyCreateEntity(SysRoleAddUpdateDto dto){
        throwIfExistAccount("roleName",dto.getRoleName());
        return (SysRoleInfo)ToolUtil.copyProperties(dto,SysRoleInfo.class);
    }



    /**
     * 系统后台 新增角色  绑定资源  权限
     * **/
    @Override
    public Integer addRole(SysRoleAddUpdateDto roleDto) {
        SysRoleInfo role=verifyCreateEntity(roleDto);
        Integer successRow=save(role);
        if(roleDto.getPermissoinId()!=null&&roleDto.getPermissoinId().size()>ConstantsFlag.FLAG.ZERO.getValue())
                sysRolePermissionService.initRollePermission(role.getId(),roleDto.getPermissoinId());
        if(roleDto.getResourceId()!=null&&roleDto.getResourceId().size()>ConstantsFlag.FLAG.ZERO.getValue())
                sysRoleResourceService.initRolleResource(role.getId(),roleDto.getResourceId());
        return successRow;
    }
}
