package com.test.dto.translate;

import java.util.List;
import java.util.Map;

public class Youdao {

	private Integer errorCode;
	private String query;
	private List<Object> translation; // 有道翻译
	private Map<Object, Object> basic; // 有道词典-基本词典
	private List<Object> web; // 有道词典-网络释义
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	public Map<Object, Object> getBasic() {
		return basic;
	}
	public void setBasic(Map<Object, Object> basic) {
		this.basic = basic;
	}
	public List<Object> getTranslation() {
		return translation;
	}
	public void setTranslation(List<Object> translation) {
		this.translation = translation;
	}
	public List<Object> getWeb() {
		return web;
	}
	public void setWeb(List<Object> web) {
		this.web = web;
	}
	

}
