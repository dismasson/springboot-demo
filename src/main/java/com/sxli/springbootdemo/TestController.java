package com.sxli.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/sayhello")
    public String sayHello() {
        try {
            // 阻塞10S，模拟在处理业务中停止服务是否会对现有的服务造成影响
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
