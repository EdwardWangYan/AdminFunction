package com.wy.integration.dto.AddDeatilsUpdate;

import com.wy.integration.dto.AddDeatilsUpdate.Resource.RoleResourceDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public class SysRoleAddUpdateDto {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "机构主键")
    private String orgId;
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 标识代码，在同一组织机构内唯一
     */
    @ApiModelProperty(value = "标识代码 机构编码前缀")
    private String code;

    /**
     * 角色类型,1:平台;2:机构,3:通用
     */
    @ApiModelProperty(value = "色类型,1:平台;2:机构,3:通用")
    private String typeId;
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "资源集合")
    private List<RoleResourceDto> resourceId;
    @ApiModelProperty(value = "权限集合")
    private List<RolePerMissIonDto> permissoinId;

    public List<RoleResourceDto> getResourceId() {
        return resourceId;
    }

    public void setResourceId(List<RoleResourceDto> resourceId) {
        this.resourceId = resourceId;
    }

    public List<RolePerMissIonDto> getPermissoinId() {
        return permissoinId;
    }

    public void setPermissoinId(List<RolePerMissIonDto> permissoinId) {
        this.permissoinId = permissoinId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
