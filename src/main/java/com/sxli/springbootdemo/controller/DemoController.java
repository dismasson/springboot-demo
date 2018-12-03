package com.sxli.springbootdemo.controller;

import com.sxli.springbootdemo.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟全局异常跟自定义异常
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/myerror")
    public String myError() {
        try {
            int result = 1 / 0;
        } catch (Exception e) {
            throw new MyException("0000", "系统运行时出现异常");
        }
        return "myerror hello world!";
    }

    @GetMapping("/error")
    public String error() {
        int result = 1 / 0;
        return "error hello world!";
    }
}
