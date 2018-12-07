package com.wy.integration.service.impl;

import com.wy.integration.constants.ConstantsFlag;
import com.wy.integration.dao.SysResourceMapper;
import com.wy.integration.dto.AddDeatilsUpdate.SysResourceAddUpdateDto;
import com.wy.integration.dto.Common.ChildNode;
import com.wy.integration.exception.ErrCode.CMMErrorCode;
import com.wy.integration.exception.ResourceCreateException;
import com.wy.integration.exception.ResponseException;
import com.wy.integration.model.SysResource;
import com.wy.integration.model.SysRoleInfo;
import com.wy.integration.service.SysResourceService;
import com.wy.integration.utils.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by Edward on 2018/12/04.
 */
@Service
@Transactional
public class SysResourceServiceImpl extends BaseService<SysResource> implements SysResourceService {
    @Resource
    private SysResourceMapper sysResourceMapper;


    /**
     * 创建资源
     */
    @Override
    public String createResource(SysResourceAddUpdateDto dto, ConstantsFlag.ResourceLevel level) {
        verifyCreateEntity(dto);
        if (dto instanceof ChildNode) {
            assertParentLevelEqualTo(((ChildNode) dto).getParentId(), level.getParent());
        }
        SysResource o = buildResource(dto,level);
        save(o);
        return o.getId();
    }

    /**
     * 验证资源名称是否重复
     * **/
    private SysResource verifyCreateEntity(SysResourceAddUpdateDto dto){
        throwIfExistAccount("resourceTitle",dto.getResourceTitle());
        return (SysResource)ToolUtil.copyProperties(dto,SysResource.class);
    }
      /**
     * 校验 是否为附近标签 类型是否一致
     * **/
      protected void assertParentLevelEqualTo(String parentId, ConstantsFlag.ResourceLevel level) {
        SysResource parent =findById(parentId);
        if (parent == null) {
            throw new ResponseException(CMMErrorCode.RESOURCE_NOT_EXISTS);
        }
        if (!parent.getResourceType().equals(level.getVal())) {
            throw new ResourceCreateException("无法在\"" + level.getDesc() + "\"等级的资源下创建此资源");
        }
    }

    private SysResource buildResource(SysResourceAddUpdateDto dto, ConstantsFlag.ResourceLevel level) {
        SysResource o=(SysResource) ToolUtil.copyProperties(dto,SysResource.class);
        o.setResourceType(level.getVal());
        return o;
    }

}
