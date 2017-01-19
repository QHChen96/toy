package com.umoo.toy.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/18.
 * 计划任务
 */
@Service
public class ScheduledTaskService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    //@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        logger.info("currentTime:" + format.format(new Date()));
    }
}
