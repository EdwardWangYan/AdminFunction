package com.wy.integration.dto.AddDeatilsUpdate;

import io.swagger.annotations.ApiModelProperty;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public class SysResourceAddUpdateDto {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "父节点")
    private String parentId;
    @ApiModelProperty(value = "资源名称")
    private String resourceTitle;
    @ApiModelProperty(value = "资源简介")
    private String summary;
    @ApiModelProperty(value = "资源类型")
    private Double resourceType;
    @ApiModelProperty(value = "图标")
    private String resourceIcon;
    @ApiModelProperty(value = "资源URL")
    private String resourceUrl;
    @ApiModelProperty(value = "资源扩展信息EXT")
    private String resourceExt;
    @ApiModelProperty(value = "组织类型")
    private String orgType;
    @ApiModelProperty(value = "排序号")
    private Double ordersIndex;
    @ApiModelProperty(value = "说明")
    private String remark2;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getResourceType() {
        return resourceType;
    }

    public void setResourceType(Double resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceIcon() {
        return resourceIcon;
    }

    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceExt() {
        return resourceExt;
    }

    public void setResourceExt(String resourceExt) {
        this.resourceExt = resourceExt;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public Double getOrdersIndex() {
        return ordersIndex;
    }

    public void setOrdersIndex(Double ordersIndex) {
        this.ordersIndex = ordersIndex;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}