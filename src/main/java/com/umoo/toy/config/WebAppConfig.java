package com.umoo.toy.config;

import java.util.List;

import javax.servlet.MultipartConfigElement;

import com.umoo.toy.interceptor.DemoInterceptor;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableAsync
public class WebAppConfig extends WebMvcConfigurerAdapter{

	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() { 
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("10MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("10MB"); 
        //Sets the directory location where files will be stored.
        //factory.setLocation("路径地址");
        return factory.createMultipartConfig(); 
    } 
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//配置静态资源
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		super.addResourceHandlers(registry);
	}

	
	//消息装换器，例如可以自定义
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.extendMessageConverters(converters);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
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
