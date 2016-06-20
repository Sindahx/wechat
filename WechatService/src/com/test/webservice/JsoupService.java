package com.test.webservice;

import java.util.Map;

public interface JsoupService {

	/**
	 * 音频消息
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public String getVoice(Map<String, String> requestMap) throws Exception;

	/**
	 * 图片消息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getImage(Map<String, String> requestMap) throws Exception;
	
	/**
	 * 图片消息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getImage2(Map<String, String> requestMap) throws Exception;

	/**
	 * 地理位置消息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getLocation() throws Exception;

	/**
	 * 链接消息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getLink() throws Exception;

	/**
	 * 关注 回复消息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSubscribe() throws Exception;

}
