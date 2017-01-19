package com.umoo.toy.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
/**
 * 
 * @author umoo
 * 得到运行环境
 */
@Component
public class EnvironmentUtil implements EnvironmentAware{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private static Environment environment;
	private static RelaxedPropertyResolver resolver;
	public void setEnvironment(Environment environment) {
		if(EnvironmentUtil.environment != null) {
			EnvironmentUtil.environment = environment;
		}
		logger.info("environment is loaded!");
	}
	public static Environment getEnvironment() {
		return environment;
	}
	public static String getProperty(String key) {
		return getEnvironment().getProperty(key);
	}
	public static RelaxedPropertyResolver getPrefixResolver(String prefix) {
		RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(getEnvironment(), prefix);
		return resolver;
	}
}
