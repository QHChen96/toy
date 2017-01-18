package com.umoo.toy.config;

import com.umoo.toy.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableAspectJAutoProxy
@EnableAsync
public class WebAppConfig extends WebMvcConfigurerAdapter{

	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000);
		return multipartResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//配置静态资源
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
		super.addInterceptors(registry);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//不忽略点后面的参数
		configurer.setUseSuffixPatternMatch(false);
	}
}
