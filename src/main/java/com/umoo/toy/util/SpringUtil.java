package com.umoo.toy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware{
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if(SpringUtil.applicationContext != null) {
			SpringUtil.applicationContext = applicationContext;
		}
		LOG.info("applicationContext is loaded!");
	}
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	public static Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	} 
	public static <T> T getBean(String beanName, Class<T> clazz) {
		return getApplicationContext().getBean(beanName, clazz);
	}
	public static boolean containsBean(String name){
		return getApplicationContext().containsBean(name);
	}
	public static Resource getResource(String path) {
		return getApplicationContext().getResource(path);
	}
	public static void publishEvent(ApplicationEvent applicationEvent) {
		getApplicationContext().publishEvent(applicationEvent);
	}
	public static void publishEvent(Object o) {
		getApplicationContext().publishEvent(o);
	}
	public static Environment getEnvironment() {
		return getApplicationContext().getEnvironment();
	}
}
