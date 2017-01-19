package com.umoo.toy.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1) //表示会先加载
public class DemoRunner implements CommandLineRunner{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public void run(String... args) throws Exception {
		logger.info("args:" + args.toString());
	}
}
