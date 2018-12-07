package com.wy.integration.dto.AddDeatilsUpdate.Resource;


import com.wy.integration.dto.AddDeatilsUpdate.SysResourceAddUpdateDto;
import com.wy.integration.dto.Common.ChildNode;

/**
 * @author : edward
 * @since : 7/12/2018
 */
public class OperationCreateDto extends SysResourceAddUpdateDto implements ChildNode {
    private String parentId;

    @Override
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}