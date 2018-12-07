package com.wy.integration.exception;

import com.wy.integration.exception.ErrCode.CMMErrorCode;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public class ResourceCreateException extends BizExceptionWithArguments{
    public ResourceCreateException(String reason) {
        super(CMMErrorCode.RESOURCE_CREATE_ERROR, reason);
    }
}