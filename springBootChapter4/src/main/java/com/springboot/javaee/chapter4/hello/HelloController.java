package com.springboot.javaee.chapter4.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/25下午9:28
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String hello() {
        return "index";
    }
}
