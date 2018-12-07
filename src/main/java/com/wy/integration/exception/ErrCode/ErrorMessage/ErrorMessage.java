package com.wy.integration.exception.ErrCode.ErrorMessage;



import com.wy.integration.exception.ErrCode.ErrorCode;

import java.util.HashMap;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public class ErrorMessage {
    private HashMap<ErrorCode, String> zh = new HashMap();

    public ErrorMessage(HashMap<ErrorCode, String> zh) {
        this.zh = zh;
    }

    public String getErrorMessage(ErrorCode key) {
        return (String)this.zh.get(key);
    }

    public String getErrorMessage(ErrorCode key, Object... args) {
        String msg = this.getErrorMessage(key);
        return String.format(msg, args);
    }
}