package com.springboot.javaee.chapter4.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author: leiyulin
 * @description: 每5秒钟向浏览器推送消息
 * @date:2018/8/26下午9:05
 */
@Controller
public class SeeController {
    @RequestMapping(value = {"/push"}, produces = "text/event-stream;charset=UTF-8")
    public @ResponseBody
    String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() + "";
    }
}
