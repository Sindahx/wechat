package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.action.CrazyService;
import com.test.action.TokenService;
import com.test.action.imp.CrazyServiceImp;
import com.test.action.imp.TokenServiceImp;

//import com.test.util.SignUtil;

public class ServletDemo4 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CrazyService crazyService = new CrazyServiceImp(); // 任务分发

	@Resource
	private TokenService tokenService;
//	private TokenService tokenService = new TokenServiceImp(); // Token
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		String echostr = null;
		try {
			echostr = tokenService.verifyToken(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(echostr);
		out.close();
//		out = null;

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
	
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 调用核心业务类接收消息、处理消息
		String respMessage = null;
		try {
			respMessage = crazyService.processRequest(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();

	}

}
