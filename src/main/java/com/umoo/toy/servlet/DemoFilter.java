package com.umoo.toy.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(urlPatterns="/*")
public class DemoFilter extends HttpFilter{

	private static final long serialVersionUID = 835335733132338903L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info(this.getClass().getName() + ":" + filterConfig.getFilterName() + ">>> init");
//		super.init(filterConfig);
	}


	@Override
	protected void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info(this.getClass().getName() + ":" + request.getRequestURL() + ">>> doFilter");
		chain.doFilter(request, response);
	}


	public void destroy() {
		logger.info(this.getClass().getName() + ":" + ">>> destory");
	}
	
}
