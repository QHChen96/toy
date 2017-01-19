package com.umoo.toy.reslover;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.umoo.toy.dto.BaseResult;


/**
 * 
 * @author umoo
 * 统一异常处理
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@ResponseBody
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		LOGGER.error("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.getMessage());
		try {
			PrintWriter writer = response.getWriter();
			BaseResult<String> result = new BaseResult(false, ex.getMessage());
			writer.write(JSON.toJSONString(result));
			writer.flush();
		} catch (IOException e) {
			LOGGER.error("Exception:", e);
		}
		return null;
	}

}
