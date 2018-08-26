package com.springboot.javaee.chapter4.ch4_6;

import com.springboot.javaee.chapter4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26下午10:09
 */
@RestController
public class MyRestController {
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String testRest() {
        return demoService.saySomething();
    }

}
