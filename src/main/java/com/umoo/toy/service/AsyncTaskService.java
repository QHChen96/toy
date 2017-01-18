package com.umoo.toy.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/1/18.
 * 异步任务
 */
@Service
public class AsyncTaskService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Async
    /**
     * 异步方法,打算使用在批量上传
     */
    public void executeAsyncTask(Integer i) {
        logger.info("执行异步任务" + i);
    }
}
