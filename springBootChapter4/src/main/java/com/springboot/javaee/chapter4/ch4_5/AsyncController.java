package com.springboot.javaee.chapter4.ch4_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author: leiyulin
 * @description:
 * @date:2018/8/26下午9:41
 */
@Controller
public class AsyncController {
    @Autowired
    private PushService pushService;

    @RequestMapping(value = {"/defer"})
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        return pushService.getAsyncUpdate();
    }
}
