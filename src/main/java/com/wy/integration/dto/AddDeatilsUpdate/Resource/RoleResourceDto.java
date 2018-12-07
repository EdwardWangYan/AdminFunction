package com.wy.integration.dto.AddDeatilsUpdate.Resource;

import io.swagger.annotations.ApiModelProperty;

public class RoleResourceDto {
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "资源名称")
    private String resourceTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }
}
