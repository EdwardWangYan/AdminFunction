package com.wy.integration.exception;

import com.wy.integration.exception.ErrCode.ErrorCode;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BizException extends RuntimeException {
    private String code;  //错误码

    public BizException() {
    }

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}