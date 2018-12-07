package com.wy.integration.exception.ErrCode;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public interface ErrorCode {
    String getMessage(Object... var1);

    String getCode();
}