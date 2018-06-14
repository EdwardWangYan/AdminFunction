package com.wy.integration.exception;

import com.alibaba.druid.wall.violation.ErrorCode;

public class BizException extends RuntimeException {
    private ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}