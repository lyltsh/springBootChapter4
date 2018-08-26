package com.springboot.javaee.chapter4.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: leiyulin
 * @description: 使用RestController，声明是控制器，并且返回数据时不需要使用@ResponseBody
 * @date:2018/8/26上午10:19
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {
    @RequestMapping(value = "/getjson", produces = {"application/json;charset=UTF-8"})
    public DemoObj getJson(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
    }

    @RequestMapping(value = "/getxml", produces = {"application/xml;charset=UTF-8"})
    public DemoObj getXml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
    }
}
