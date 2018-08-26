package com.springboot.javaee.chapter4.service;

import org.springframework.stereotype.Service;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26下午9:54
 */
@Service
public class DemoService {
    public String saySomething() {
        return "helloService";
    }
}
