package com.wy.integration.utils.page;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class DataPageResponse<T> {
    @ApiModelProperty("分页前的总条目数")
    private Long total;
    @ApiModelProperty("分页后的数据")
    private List<T> rows;

    public DataPageResponse() {
    }

    public Long getTotal() {
        return this.total == null ? 0L : this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        if (this.rows == null) {
            this.rows = new ArrayList();
        }

        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public void add(T row) {
        this.getRows().add(row);
    }

    public void addAll(List<T> rows) {
        this.getRows().addAll(rows);
    }

    public static <T> DataPageResponse<T> empty() {
        DataPageResponse<T> o = new DataPageResponse();
        o.setTotal(0L);
        o.setRows(new ArrayList());
        return o;
    }

    public static <T> DataPageResponse<T> fromPageInfo(PageInfo<T> pageInfo) {
        DataPageResponse<T> o = new DataPageResponse();
        o.setTotal(pageInfo.getTotal());
        o.setRows(pageInfo.getList());
        return o;
    }
}