package com.umoo.toy.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * Created by Administrator on 2017/1/18.
 */
public class DemoListener implements ApplicationListener<DemoEvent>{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        logger.info(msg);
    }
}
