package com.umoo.toy.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value=BizException.class)
	@ResponseBody
	@ResponseStatus(reason = "biz exception")
	public void defaultExceptionHandler(HttpServletRequest request, Exception e){
		LOG.info(e.getMessage());
	}
}
