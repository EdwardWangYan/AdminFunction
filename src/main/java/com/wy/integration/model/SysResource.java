package com.wy.integration.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource")
public class SysResource {
    @Id
    private String id;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "resource_title")
    private String resourceTitle;

    private String summary;

    @Column(name = "resource_type")
    private Double resourceType;

    @Column(name = "resource_icon")
    private String resourceIcon;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "resource_ext")
    private String resourceExt;

    @Column(name = "org_type")
    private String orgType;

    @Column(name = "orders_index")
    private Double ordersIndex;

    private String remark2;

    @Column(name = "del_flag")
    private Double delFlag;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "update_by")
    private String updateBy;

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
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return resource_title
     */
    public String getResourceTitle() {
        return resourceTitle;
    }

    /**
     * @param resourceTitle
     */
    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    /**
     * @return summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return resource_type
     */
    public Double getResourceType() {
        return resourceType;
    }

    /**
     * @param resourceType
     */
    public void setResourceType(Double resourceType) {
        this.resourceType = resourceType;
    }

    /**
     * @return resource_icon
     */
    public String getResourceIcon() {
        return resourceIcon;
    }

    /**
     * @param resourceIcon
     */
    public void setResourceIcon(String resourceIcon) {
        this.resourceIcon = resourceIcon;
    }

    /**
     * @return resource_url
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param resourceUrl
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * @return resource_ext
     */
    public String getResourceExt() {
        return resourceExt;
    }

    /**
     * @param resourceExt
     */
    public void setResourceExt(String resourceExt) {
        this.resourceExt = resourceExt;
    }

    /**
     * @return org_type
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * @param orgType
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**
     * @return orders_index
     */
    public Double getOrdersIndex() {
        return ordersIndex;
    }

    /**
     * @param ordersIndex
     */
    public void setOrdersIndex(Double ordersIndex) {
        this.ordersIndex = ordersIndex;
    }

    /**
     * @return remark2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * @param remark2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    /**
     * @return del_flag
     */
    public Double getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Double delFlag) {
        this.delFlag = delFlag;
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
}