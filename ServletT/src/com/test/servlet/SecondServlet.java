package com.test.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 定义上载文件的最大字节
		
		ServletInputStream input = request.getInputStream();
		String consultContext = request.getParameter("consultContext");
		  String consultType = request.getParameter("consultType");
		  //String fileAddress = request.getParameter("fileAddress");
		  String userUid = request.getParameter("userUid");
		  String userToken = request.getParameter("userToken");
		  String rp="";
		  List<String> fileNames = null;
		  // 解析器
//		  CommonsMultipartResolver multipartResolver = UploadUtil.createCommonsMultipartResolver(request);
		  // 判断 request 是否有文件上传,即多部分请求
//		  if(multipartResolver.isMultipart(request)){
//		   MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
//		  // 上传图片根
//		   rp = (String) SpringPropertyUtil.getContextProperty(Constant.DFFX_DIR_UPLOAD_ACTIVITY);
//		  // 上传图片
//		   fileNames = UploadUtil.saveFiles(multiRequest,rp);
//		  }

	}

}
