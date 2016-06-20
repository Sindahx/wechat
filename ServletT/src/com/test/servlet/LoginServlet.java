package com.test.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userName = req.getParameter("uname");
		String password = req.getParameter("password");
		
		String file = req.getParameter("file");

		String contextPath = req.getContextPath();
		System.out.println(contextPath);

		if (userName.equals("sinda") && password.equals("123456")) {
			String path = "hello.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(path);

			rd.forward(req, resp);
		} else {
			String path = "error.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(path);
			req.setAttribute("msg", "账号或者密码不正确!!!");

			rd.forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(req, resp);
	}
}
