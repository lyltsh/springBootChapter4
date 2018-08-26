package com.springboot.javaee.chapter4.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: leiyulin
 * @description: 自定义拦截器，返回处理时间
 * @date:2018/8/26上午10:46
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "startTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME, startTime);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        long startTime = (long) request.getAttribute(START_TIME);
        request.removeAttribute(START_TIME);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("本次系统处理时间:" + new Long(endTime - startTime) + "ms");
        request.setAttribute("handlingTime", endTime - startTime);
    }
}
