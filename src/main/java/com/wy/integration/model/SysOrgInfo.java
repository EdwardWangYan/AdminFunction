package com.wy.integration.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_org_info")
public class SysOrgInfo {
    @Id
    private String id;

    /**
     * 机构名称
     */
    private String title;

    private String code;

    /**
     * 机构类型ID，关联机构类型表
     */
    @Column(name = "org_type_code")
    private String orgTypeCode;

    /**
     * 机构全称
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * 机构简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 机构简称代码
     */
    @Column(name = "short_code")
    private String shortCode;

    /**
     * 父机构类别，关联本表ID字段，
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 图片、文件资源与文件表中ID关联
     */
    @Column(name = "org_logo_id")
    private String orgLogoId;

    private String website;

    private String email;

    private String telephone;

    @Column(name = "contact_person")
    private String contactPerson;

    private String summary;

    private String remark;

    /**
     * 用于标识该记录状态情况只有STATUS != 0的记录才能被业务逻辑使用，0：无效，1：有效，默认为1。
     */
    private Integer status;

    /**
     * 用于记录的逻辑删除，0：删除，1：正常，默认为1
            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作
            
     */
    @Column(name = "del_flag")
    private Integer delFlag;

    /**
     * 创建时间，创建该记录的系统时间。
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建人ID，为系统用户表中的当前登录用户ID。
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 最近一次修改该记录的用户ID，可以为空或为首次创建人的ID
     */
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
     * 获取机构名称
     *
     * @return title - 机构名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置机构名称
     *
     * @param title 机构名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取机构类型ID，关联机构类型表
     *
     * @return org_type_code - 机构类型ID，关联机构类型表
     */
    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    /**
     * 设置机构类型ID，关联机构类型表
     *
     * @param orgTypeCode 机构类型ID，关联机构类型表
     */
    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    /**
     * 获取机构全称
     *
     * @return full_name - 机构全称
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置机构全称
     *
     * @param fullName 机构全称
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 获取机构简称
     *
     * @return short_name - 机构简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 设置机构简称
     *
     * @param shortName 机构简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 获取机构简称代码
     *
     * @return short_code - 机构简称代码
     */
    public String getShortCode() {
        return shortCode;
    }

    /**
     * 设置机构简称代码
     *
     * @param shortCode 机构简称代码
     */
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * 获取父机构类别，关联本表ID字段，
     *
     * @return parent_id - 父机构类别，关联本表ID字段，
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父机构类别，关联本表ID字段，
     *
     * @param parentId 父机构类别，关联本表ID字段，
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取图片、文件资源与文件表中ID关联
     *
     * @return org_logo_id - 图片、文件资源与文件表中ID关联
     */
    public String getOrgLogoId() {
        return orgLogoId;
    }

    /**
     * 设置图片、文件资源与文件表中ID关联
     *
     * @param orgLogoId 图片、文件资源与文件表中ID关联
     */
    public void setOrgLogoId(String orgLogoId) {
        this.orgLogoId = orgLogoId;
    }

    /**
     * @return website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return contact_person
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contactPerson
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取用于标识该记录状态情况只有STATUS != 0的记录才能被业务逻辑使用，0：无效，1：有效，默认为1。
     *
     * @return status - 用于标识该记录状态情况只有STATUS != 0的记录才能被业务逻辑使用，0：无效，1：有效，默认为1。
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用于标识该记录状态情况只有STATUS != 0的记录才能被业务逻辑使用，0：无效，1：有效，默认为1。
     *
     * @param status 用于标识该记录状态情况只有STATUS != 0的记录才能被业务逻辑使用，0：无效，1：有效，默认为1。
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用于记录的逻辑删除，0：删除，1：正常，默认为1
            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作
            
     *
     * @return del_flag - 用于记录的逻辑删除，0：删除，1：正常，默认为1
            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作
            
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 设置用于记录的逻辑删除，0：删除，1：正常，默认为1
            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作
            
     *
     * @param delFlag 用于记录的逻辑删除，0：删除，1：正常，默认为1
            业务逻辑中：若DELETED_FLAG = 0为删除状态，则该记录一点不能被操作
            
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取创建时间，创建该记录的系统时间。
     *
     * @return create_date - 创建时间，创建该记录的系统时间。
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间，创建该记录的系统时间。
     *
     * @param createDate 创建时间，创建该记录的系统时间。
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人ID，为系统用户表中的当前登录用户ID。
     *
     * @return create_by - 创建人ID，为系统用户表中的当前登录用户ID。
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人ID，为系统用户表中的当前登录用户ID。
     *
     * @param createBy 创建人ID，为系统用户表中的当前登录用户ID。
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。
     *
     * @return update_date - 上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。
     *
     * @param updateDate 上一次修改该记录的时间，未修改过可以为空或为创建记录的时间。
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取最近一次修改该记录的用户ID，可以为空或为首次创建人的ID
     *
     * @return update_by - 最近一次修改该记录的用户ID，可以为空或为首次创建人的ID
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置最近一次修改该记录的用户ID，可以为空或为首次创建人的ID
     *
     * @param updateBy 最近一次修改该记录的用户ID，可以为空或为首次创建人的ID
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}