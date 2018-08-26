package com.springboot.javaee.chapter4.ch4_5;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author: leiyulin
 * @description:
 * 在PushService产生DeferredResult给控制器使用，通过Scheduled定时任务更新DeferredResult
 * @date:2018/8/26下午9:34
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (null != deferredResult) {
            String result = Long.toString(System.currentTimeMillis());
            deferredResult.setResult(result);
        }
    }
}
