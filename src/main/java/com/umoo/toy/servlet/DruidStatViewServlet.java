package com.umoo.toy.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns = {"/druid/*"},
	initParams = {
		@WebInitParam(name="allow", value="127.0.0.1"),//白名单
		@WebInitParam(name="dency", value=""),//黑名单
		@WebInitParam(name="loginUsername", value="admin"),
		@WebInitParam(name="loginPassword", value="123456"),
		@WebInitParam(name="resetEnable",value="false")
	}
)
public class DruidStatViewServlet extends StatViewServlet{
	private static final long serialVersionUID = 8254253176171615406L;
}
