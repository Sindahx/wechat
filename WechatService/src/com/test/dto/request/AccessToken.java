package com.test.dto.request;

public class AccessToken {
	
	private String access_token;
	private String expires_in;
	private String errcode;
	private String errmsg;
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expiresIn) {
		expires_in = expiresIn;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}