package com.wy.integration.dto.AddDeatilsUpdate;

import com.wy.integration.dto.AddDeatilsUpdate.Resource.RoleResourceDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author : edward
 * @since : 7/12/2018
 */
public class UserRoleDto {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
