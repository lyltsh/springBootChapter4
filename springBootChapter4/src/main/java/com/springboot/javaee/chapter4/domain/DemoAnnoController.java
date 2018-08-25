package com.springboot.javaee.chapter4.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/25下午10:51
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String demoPathVar(HttpServletRequest request, @PathVariable String str) {
        return "url" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/requestparam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passRequestParam(Long id, HttpServletRequest request) {
        return "url" + request.getRequestURL() + " can access, id: " + id;
    }

    @RequestMapping(value = "/obj", produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String passObj(HttpServletRequest request, DemoObj obj) {
        return "url" + request.getRequestURL() + " can access, obj id: " + obj.getId() + ", obj name:" + obj.getName();
    }

    @RequestMapping(value = {"/name", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody
    String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }
}
