package com.umoo.toy.advice;

import javax.servlet.http.HttpServletRequest;

import com.umoo.toy.exception.BizException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * Created by Administrator on 2017/1/19.
 */
@ControllerAdvice
public class DemoControllerAdvice {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(value= BizException.class)
    public void handlerException(WebRequest request, Exception e) {
    	
    }
    
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR, reason = "超过限制")
    @ResponseBody
    public void handlerUploadException(HttpServletRequest request, Exception e) {
    	logger.error(e.getMessage());
    }
    
    @ModelAttribute
    public void addAttribute(Model model) {
        //model.addAttribute() 配置每个请求都能得到的键值对
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //对设置参数
    }
}
