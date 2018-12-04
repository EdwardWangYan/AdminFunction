package com.wy.integration.exception.ErrCode;

import com.wy.integration.exception.ErrCode.ErrorMessage.ErrorMessage;

import java.util.HashMap;

/**
 * 错误码
 * @author Edward Wang
 *
 */
public enum CMMErrorCode implements ErrorCode {
    
    //用户
    USER_TITLE_IS_EXISTS("1000"),
    USER_NOT_EXISTS("1001"),
    ID_IS_NULL("1001"),
    ENTITY_IS_NULL("1002"),

    //其他
    ORG_TITLE_IS_EXISTS("9001"),
    //错误

     EROR("9999");

    private static HashMap<ErrorCode, String> map = new HashMap<>();

    static {

        map.put(CMMErrorCode.USER_TITLE_IS_EXISTS, "用户标题已经存在");
        map.put(CMMErrorCode.USER_NOT_EXISTS, "用户不经存在");
        map.put(CMMErrorCode.ID_IS_NULL, "实体主键不能为空");
        map.put(CMMErrorCode.ENTITY_IS_NULL, "校验实体不存在，不可进行操作");
        map.put(CMMErrorCode.ORG_TITLE_IS_EXISTS, "该机构已经存在");
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