package com.wy.integration.dto.AddDeatilsUpdate;

import io.swagger.annotations.ApiModelProperty;

public class RolePerMissIonDto {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "权限名称")
    private String permissionName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
