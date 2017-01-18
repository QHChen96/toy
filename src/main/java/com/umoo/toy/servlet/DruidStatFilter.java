package com.umoo.toy.servlet;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName="druidStatFilter",
	urlPatterns = "/*",
	initParams = {
		@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
	}
)
public class DruidStatFilter extends WebStatFilter{

}
