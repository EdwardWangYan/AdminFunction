package com.wy.integration.exception;


import com.wy.integration.exception.ErrCode.CMMErrorCode;

public class ResponseException extends BizException{

    public ResponseException(CMMErrorCode errorCode) {
        super(errorCode);
    }

}
