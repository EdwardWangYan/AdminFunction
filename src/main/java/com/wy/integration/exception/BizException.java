package com.wy.integration.exception;

import com.wy.integration.exception.ErrCode.ErrorCode;

public class BizException extends RuntimeException {
    private ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}