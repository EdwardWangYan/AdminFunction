package com.wy.integration.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_group")
public class SysGroup {
    @Id
    private String id;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 父分组ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    private Long level;

    /**
     * 分组序列号
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 分组排序值
     */
    private Short sort;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;

    private String remarks;

    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取分组名称
     *
     * @return name - 分组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分组名称
     *
     * @param name 分组名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父分组ID
     *
     * @return parent_id - 父分组ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父分组ID
     *
     * @param parentId 父分组ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return level
     */
    public Long getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Long level) {
        this.level = level;
    }

    /**
     * 获取分组序列号
     *
     * @return parent_ids - 分组序列号
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置分组序列号
     *
     * @param parentIds 分组序列号
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取分组排序值
     *
     * @return sort - 分组排序值
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置分组排序值
     *
     * @param sort 分组排序值
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_by
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return del_flag
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}