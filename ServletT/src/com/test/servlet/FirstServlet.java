package com.test.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet{


	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		OutputStream out =res.getOutputStream();  
        out.write("Hello,World!!!".getBytes());  
        out.write("Hello,World!!!".getBytes());  
	}

}
