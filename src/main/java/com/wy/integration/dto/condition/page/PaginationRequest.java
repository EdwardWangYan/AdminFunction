package com.wy.integration.dto.condition.page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiParam;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public abstract class PaginationRequest {
    private static final int DEF_INDEX = 1;
    private static final int DEF_SIZE = 20;
    @ApiParam(
        value = "分页开始页数",
        defaultValue = "1"
    )
    private Integer index;
    @ApiParam(
        value = "分页每页大小",
        defaultValue = "20"
    )
    private Integer size;

    public PaginationRequest() {
    }

    @JsonIgnore
    public Integer getOffset() {
        return this.getSize() * (this.getIndex() - 1);
    }

    @JsonIgnore
    public Integer getLimit() {
        return this.getSize();
    }

    public Integer getIndex() {
        return this.index != null && this.index > 0 ? this.index : 1;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getSize() {
        return this.size != null && this.size > 0 ? this.size : 20;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}