package com.springboot.javaee.chapter4.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26上午11:30
 */
@ControllerAdvice
public class ExeceptionHandlerAdvice {

    /*
     * ExceptionHandler此处定义了一个全局处理，拦截了所有的Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error"); //error page
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /*
    全局ModelAttribute
     */
    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
