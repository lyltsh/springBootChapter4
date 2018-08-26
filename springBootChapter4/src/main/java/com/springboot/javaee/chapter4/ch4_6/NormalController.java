package com.springboot.javaee.chapter4.ch4_6;

import com.springboot.javaee.chapter4.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26下午10:05
 */
@Controller
public class NormalController {
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = {"/normal"})
    public String testPage(Model model) {
        model.addAttribute("msg", demoService.saySomething());
        return "page";
    }

}
