package com.umoo.toy.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebAppConfig extends WebMvcConfigurerAdapter{

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//配置静态资源
		super.addResourceHandlers(registry);
	}
	
	
}
