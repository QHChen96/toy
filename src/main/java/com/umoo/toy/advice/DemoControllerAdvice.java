package com.umoo.toy.advice;

import com.umoo.toy.exception.BizException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Administrator on 2017/1/19.
 */
@ControllerAdvice
public class DemoControllerAdvice {
    @ExceptionHandler(value= BizException.class)
    public void handlerException(WebRequest request, Exception e) {

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
