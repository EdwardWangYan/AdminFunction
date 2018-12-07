package com.wy.integration.exception;

import com.wy.integration.exception.ErrCode.ErrorCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author : edward
 * @since : 7/12/2018
 */
public class BizExceptionWithArguments extends BizException {
    private List<String> args = new ArrayList();

    public List<String> getArgs() {
        return this.args;
    }

    public BizExceptionWithArguments(ErrorCode errorCode, String... args) {
        super(errorCode);
        this.args = Arrays.asList(args);
    }
}