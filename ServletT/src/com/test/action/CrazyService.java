package com.test.action;

import javax.servlet.http.HttpServletRequest;

public interface CrazyService {
	
	/**
	 * 从微信接口收到的内容
	 * 分发任务
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public String processRequest(HttpServletRequest request)throws Exception;
}
