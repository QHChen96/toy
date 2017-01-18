package com.umoo.toy.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Scheduled(cron="* 0/10 * * * ?")
	public void scheduler(){
		LOG.info("Scheduling..");
	}
}
