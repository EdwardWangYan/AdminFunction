package com.wy.integration.utils.ResPonseUtils;

import io.swagger.annotations.ApiModelProperty;

public class RestfulApiResponse<T> {
    public static final String SUCCESS_CODE = "0";
    public static final int SUCCESS_STATE = 1;
    public static final int FAILURE_STATE = 0;
    public static final int ERROR_STATE = -1;
    @ApiModelProperty(
        value = "请求执行状态",
        example = "0",
        allowableValues = "-1, 0, 1"
    )
    private Integer state;
    @ApiModelProperty(
        value = "具体的错误码",
        example = "0",
        notes = "请求执行成功时为0，其余皆为业务异常",
        allowableValues = "range[0, 50000]"
    )
    private String code;
    @ApiModelProperty(
        value = "错误提示信息",
        example = "操作成功"
    )
    private String msg;
    @ApiModelProperty(
        value = "返回数据",
        example = "{}"
    )
    private T data;
    @ApiModelProperty(
        value = "堆栈追踪信息",
        example = ""
    )
    private String stackTrace;

    public RestfulApiResponse() {
    }

    public RestfulApiResponse(Integer state, String code, String msg) {
        this.state = state;
        this.code = code;
        this.msg = msg;
    }

    public RestfulApiResponse(Integer state, String code, String msg, T data) {
        this.state = state;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestfulApiResponse(Integer state, String code, String msg, String stackTrace) {
        this.state = state;
        this.code = code;
        this.msg = msg;
        this.stackTrace = stackTrace;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public static <T> RestfulApiResponse<T> success(String message, T data) {
        return new RestfulApiResponse(1, "0", message, data);
    }

    public static <T> RestfulApiResponse<T> success(T data) {
        return new RestfulApiResponse(1, "0", "操作成功", data);
    }

    public static <T> RestfulApiResponse<T> success(String message) {
        return new RestfulApiResponse(1, "0", message);
    }

    public static <T> RestfulApiResponse<T> success() {
        return new RestfulApiResponse(1, "0", "操作成功");
    }

    public static <T> RestfulApiResponse<T> failure(String code, String message) {
        return new RestfulApiResponse(0, code, message, "");
    }

    public static <T> RestfulApiResponse<T> failure(String code, String message, String stackTrace) {
        return new RestfulApiResponse(0, code, message, stackTrace);
    }

    public static <T> RestfulApiResponse<T> error(String message, String stackTrace) {
        return new RestfulApiResponse(-1, "-1", message, stackTrace);
    }
}