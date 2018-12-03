package com.sxli.springbootdemo.handler;

import com.sxli.springbootdemo.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GobalExceptionHandler {

    /**
     * 处理全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Map errHandler(Exception e) {
        Map result = new HashMap(4, 1);
        result.put("errCode", "0000");
        result.put("errMsg", e.getMessage());
        return result;
    }

    /**
     * 处理自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Map errHandler(MyException e) {
        Map result = new HashMap(4, 1);
        result.put("errCode", e.getErrCode());
        result.put("errMsg", e.getErrMsg());
        return result;
    }
}
