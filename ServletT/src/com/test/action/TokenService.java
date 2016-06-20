package com.test.action;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

	/**
	 * 验证token
	 * @return
	 * @throws Exception
	 */
	public String verifyToken(HttpServletRequest request)throws Exception;
}
