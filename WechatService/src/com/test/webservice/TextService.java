package com.test.webservice;

public interface TextService {

	/**
	 * 文本消息
	 * @param context
	 * @return
	 * @throws Exception
	 */
//	public String getText(String context) throws Exception;
	
	/**
	 * 文本消息
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public String getTextYoudao(String context) throws Exception;
	
	/**
	 * 文本消息
	 * @param context
	 * @return
	 * @throws Exception
	 */
	public String getTextKing(String context) throws Exception;
	
	/**
	 * 获取每日一句
	 * @return
	 * @throws Exception
	 */
	public String getDailySentence()throws Exception;
}
