package com.wy.integration.configurer.handler;

import com.wy.integration.exception.BizException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
 * @author : edward
 * @since : 7/12/2018
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BizException.class)
    public Map defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        Map map = new HashMap();
        if(e instanceof BizException) {
            BizException businessException = (BizException)e;
            map.put("code", businessException.getCode());
            map.put("msg", businessException.getMessage());
        }else{
            map.put("code", -1);
            map.put("msg", "系统异常");
        }
        //未知错误
        return map;
    }
}