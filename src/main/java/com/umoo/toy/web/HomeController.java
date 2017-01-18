package com.umoo.toy.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umoo.toy.exception.BizException;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String Hello(){
		throw new BizException("业务异常");
		//return "Hello World!!!!";
	}
}
