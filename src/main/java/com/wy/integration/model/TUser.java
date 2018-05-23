package com.wy.integration.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    /**
     * 编号
     */
    @Id
    private String id;

    /**
     * 名称
     */
    private String name;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "deleted_flag")
    private Integer deletedFlag;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return created_time
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return deleted_flag
     */
    public Integer getDeletedFlag() {
        return deletedFlag;
    }

    /**
     * @param deletedFlag
     */
    public void setDeletedFlag(Integer deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
}