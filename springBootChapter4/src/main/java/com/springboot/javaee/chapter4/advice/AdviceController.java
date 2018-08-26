package com.springboot.javaee.chapter4.advice;

import com.springboot.javaee.chapter4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26上午11:56
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomeThing(@ModelAttribute("msg") String msg, DemoObj obj) {
        throw new IllegalArgumentException("参数有误" + "来自@ModelAttribute:" + msg);
    }
}
