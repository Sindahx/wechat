package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		long cookieValue = System.currentTimeMillis();
		Integer connectCount = 0;

		// 获得用户的时间Cookie
		Cookie cookies[] = req.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("lastAccessTime")) {
				// 得到用户上次访问的时间
				cookieValue = Long.parseLong(cookies[i].getValue());
			}
			if (cookies[i].getName().equals("connectCount")) {
				// 得到用户上次访问的时间
				connectCount = Integer.valueOf(cookies[i].getValue());
			}
		}
		connectCount++;
		Date date = new Date(cookieValue);
		DateFormat formatter = DateFormat.getDateTimeInstance();

		out.print("您上次的访问时间是：");
		out.print(formatter.format(date));
		out.print("\r\n访问次数：");
		out.print(connectCount);

		// 给用户送去上次访问时间
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		Cookie cookie1 = new Cookie("connectCount", connectCount + "");
		cookie.setMaxAge(1 * 30 * 24 * 3600);
		cookie.setPath("E:/");
		resp.addCookie(cookie); // 把cookie写给浏览器
		resp.addCookie(cookie1); // 把cookie写给浏览器

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		doGet(req, resp);
	}

}
