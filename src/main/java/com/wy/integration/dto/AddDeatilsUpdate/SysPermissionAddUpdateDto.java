package com.wy.integration.dto.AddDeatilsUpdate;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : edward
 * @since : 7/12/2018
 */
public class SysPermissionAddUpdateDto {
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    @ApiModelProperty(value = "色类型,1:平台;2:机构,3:通用")
    private String permissionCode;
    @ApiModelProperty(value = "机构主键")
    private String orgId;
    /**
     * 本权限的中文释义
     */
    @ApiModelProperty(value = "权限名称")
    private String permissionName;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
