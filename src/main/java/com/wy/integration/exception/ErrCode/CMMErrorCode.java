package com.wy.integration.exception.ErrCode;

import com.wy.integration.exception.ErrCode.ErrorMessage.ErrorMessage;

import java.util.HashMap;

/**
 * 错误码
 * @author Edward Wang
 *
 */
public enum CMMErrorCode implements ErrorCode {
    

    SCMPRODUCTQUANTITY_NOT_FOUND_ERROR("4016");

    private static HashMap<ErrorCode, String> map = new HashMap<>();

    static {

        map.put(CMMErrorCode.SCMPRODUCTQUANTITY_NOT_FOUND_ERROR, "价格段信息不存在");

    }

    private static ErrorMessage errorMessage = new ErrorMessage(map);

    private String code;

    CMMErrorCode(String code) {
        this.code = code;
    }

    public String getMessage(Object... args) {
        return errorMessage.getErrorMessage(this, args);
    }

    public String getCode() {
        return code;
    }
}