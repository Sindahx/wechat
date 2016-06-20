package com.test.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	private ServletConfig config;
//	private ServletContext context;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		

		String str1 = (String) req.getParameter("str");
		String str2 = config.getInitParameter("date");

		this.getServletContext().setAttribute("data",str1);
		
		
		OutputStream out = resp.getOutputStream();
		out.write(str2.getBytes());
		out.write("\n".getBytes());
		out.write(str1.getBytes("UTF-8"));
		out.write("\n".getBytes());
		out.write(req.getLocalAddr().getBytes("UTF-8"));
		out.write("\n".getBytes());
		String host = req.getLocalName();
		out.write(host.getBytes());
		


	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		doGet(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.config = config;
//		context =this.getServletConfig().getServletContext();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}


	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

}
