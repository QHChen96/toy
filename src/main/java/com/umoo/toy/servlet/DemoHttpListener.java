package com.umoo.toy.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class DemoHttpListener implements HttpSessionListener{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("session is created..." + "[" + se.getSession().getId() + "]");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("session is destroyed..." + "[" + se.getSession().getId() + "]");
	}
	
}
