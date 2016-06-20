package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterOne implements Filter {

	public FilterOne() {
		System.out.println("========构造函数========");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("========初始化========");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("========开始执行 doFilter========");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse heepResponse = (HttpServletResponse) response;
		chain.doFilter(httpRequest, heepResponse);
		System.out.println("========结束执行 doFilter========");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("========销毁方法========");
	}

}
