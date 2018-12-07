package com.wy.integration.exception;


import com.wy.integration.exception.ErrCode.CMMErrorCode;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public class ResponseException extends BizException{

    public ResponseException(CMMErrorCode errorCode) {
        super(errorCode);
    }

}
