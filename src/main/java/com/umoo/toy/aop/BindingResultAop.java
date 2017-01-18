package com.umoo.toy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.umoo.toy.dto.BaseResult;


/**
 * 
 * @author umoo
 * 统一验证错误信息
 */

@Aspect
@Component
public class BindingResultAop {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("execution(* com.umoo.toy.web.*.*(..))")
	public void aopMethod () {}
	
	@Around("aopMethod()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		LOGGER.info("before method invoking!");
		BindingResult bindingResult = null;
		for(Object arg : joinPoint.getArgs()) {
			if(arg instanceof BindingResult) {
				bindingResult = (BindingResult)arg;
			}
		}
		if(bindingResult != null && bindingResult.hasErrors()) {
			String errorInfo = "[" + bindingResult.getFieldError().getField() + "]" + bindingResult.getFieldError().getDefaultMessage();
			return new BaseResult<Object>(false, errorInfo);
		}
		return joinPoint.proceed();
	}
}
