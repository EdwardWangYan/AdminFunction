package com.wy.integration.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu {
    @Id
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 菜单层级
     */
    private Long level;

    /**
     * 父菜单联集
     */
    @Column(name = "parent_ids")
    private String parentIds;

    /**
     * 排序
     */
    private Short sort;

    /**
     * 链接地址
     */
    private String href;

    /**
     * 打开方式
     */
    private String target;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 显示背景色
     */
    @Column(name = "bg_color")
    private String bgColor;

    /**
     * 是否显示
     */
    @Column(name = "is_show")
    private Byte isShow;

    /**
     * 权限标识
     */
    private String permission;

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
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父菜单
     *
     * @return parent_id - 父菜单
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单
     *
     * @param parentId 父菜单
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取菜单层级
     *
     * @return level - 菜单层级
     */
    public Long getLevel() {
        return level;
    }

    /**
     * 设置菜单层级
     *
     * @param level 菜单层级
     */
    public void setLevel(Long level) {
        this.level = level;
    }

    /**
     * 获取父菜单联集
     *
     * @return parent_ids - 父菜单联集
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * 设置父菜单联集
     *
     * @param parentIds 父菜单联集
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 获取链接地址
     *
     * @return href - 链接地址
     */
    public String getHref() {
        return href;
    }

    /**
     * 设置链接地址
     *
     * @param href 链接地址
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 获取打开方式
     *
     * @return target - 打开方式
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置打开方式
     *
     * @param target 打开方式
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取显示背景色
     *
     * @return bg_color - 显示背景色
     */
    public String getBgColor() {
        return bgColor;
    }

    /**
     * 设置显示背景色
     *
     * @param bgColor 显示背景色
     */
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * 获取是否显示
     *
     * @return is_show - 是否显示
     */
    public Byte getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示
     *
     * @param isShow 是否显示
     */
    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取权限标识
     *
     * @return permission - 权限标识
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限标识
     *
     * @param permission 权限标识
     */
    public void setPermission(String permission) {
        this.permission = permission;
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