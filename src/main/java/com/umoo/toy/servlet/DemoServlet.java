package com.umoo.toy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns="/demoServlet/*")
public class DemoServlet extends HttpServlet{

	private static final long serialVersionUID = 594987784479546760L;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.info("doGet>>>>:" + req.getRequestURL());
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.info("doGet>>>>:" + req.getRequestURL());
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<title>");
		writer.write("demoServlet");
		writer.write("</title>");
		writer.write("<body>");
		writer.write("<h1>");
		writer.write("Hello World!");
		writer.write("</h1>");
		writer.write("</html>");
	}

	
}
