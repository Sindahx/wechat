package com.test.service.http;

public interface WeCharSupport {
	
	/**
	 * 获取微信AccessToken
	 * @return
	 */
	public String getAccessToken()throws Exception;
	
	/**
	 * 上传文件到微信
	 * @return
	 * @throws Exception
	 */
	public String uploadMedio(String type,String filePath,String token,String optType) throws Exception;

}
