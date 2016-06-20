package com.test.action.imp;

import javax.servlet.http.HttpServletRequest;

import com.test.action.TokenService;
import com.test.util.WeixinMessageDigest;

public class TokenServiceImp implements TokenService {

	@Override
	public String verifyToken(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		
		if (WeixinMessageDigest.verifyToken(signature, timestamp, nonce)) {

			return echostr;
		}

		 return null;
	}

}

	
