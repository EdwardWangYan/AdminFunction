package com.wy.integration.configurer.handler;

import com.wy.integration.core.Result;
import com.wy.integration.exception.BizException;
import com.wy.integration.utils.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ApiResult defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if(e instanceof BizException) {
            BizException businessException = (BizException)e;
            return ResultUtil.error(businessException.getCode(), businessException.getMessage());
        }
        //未知错误
        return ResultUtil.error(-1, "系统异常：\\n"+e);
    }
}