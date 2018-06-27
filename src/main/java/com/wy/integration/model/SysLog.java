package com.wy.integration.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_log")
public class SysLog {
    /**
     * 编号
     */
    @Id
    private String id;

    private String type;

    private String title;

    @Column(name = "remote_addr")
    private String remoteAddr;

    private String username;

    @Column(name = "request_uri")
    private String requestUri;

    @Column(name = "http_method")
    private String httpMethod;

    @Column(name = "class_method")
    private String classMethod;

    @Column(name = "session_id")
    private String sessionId;

    /**
     * 方法执行时间
     */
    @Column(name = "use_time")
    private Long useTime;

    private String browser;

    private String area;

    private String province;

    private String city;

    private String isp;

    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;

    private String remarks;


    private String params;

    private String response;

    private String exception;

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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return remote_addr
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * @param remoteAddr
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return request_uri
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * @param requestUri
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * @return http_method
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * @param httpMethod
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * @return class_method
     */
    public String getClassMethod() {
        return classMethod;
    }

    /**
     * @param classMethod
     */
    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    /**
     * @return session_id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取方法执行时间
     *
     * @return use_time - 方法执行时间
     */
    public Long getUseTime() {
        return useTime;
    }

    /**
     * 设置方法执行时间
     *
     * @param useTime 方法执行时间
     */
    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    /**
     * @return browser
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * @param browser
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    /**
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return isp
     */
    public String getIsp() {
        return isp;
    }

    /**
     * @param isp
     */
    public void setIsp(String isp) {
        this.isp = isp;
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
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
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
     * @return params
     */
    public String getParams() {
        return params;
    }

    /**
     * @param params
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * @return response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return exception
     */
    public String getException() {
        return exception;
    }

    /**
     * @param exception
     */
    public void setException(String exception) {
        this.exception = exception;
    }
}