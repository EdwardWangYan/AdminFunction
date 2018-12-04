package com.wy.integration.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_info")
public class SysRoleInfo {
    @Id
    private String id;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "role_name")
    private String roleName;

    /**
     * 标识代码，在同一组织机构内唯一
     */
    private String code;

    /**
     * 角色类型,1:平台;2:机构,3:通用
     */
    @Column(name = "type_id")
    private String typeId;

    private String remark;

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
     * @return org_id
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * @param orgId
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取标识代码，在同一组织机构内唯一
     *
     * @return code - 标识代码，在同一组织机构内唯一
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置标识代码，在同一组织机构内唯一
     *
     * @param code 标识代码，在同一组织机构内唯一
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取角色类型,1:平台;2:机构,3:通用
     *
     * @return type_id - 角色类型,1:平台;2:机构,3:通用
     */
    public String getTypeId() {
        return typeId;
    }

    /**
     * 设置角色类型,1:平台;2:机构,3:通用
     *
     * @param typeId 角色类型,1:平台;2:机构,3:通用
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId;
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