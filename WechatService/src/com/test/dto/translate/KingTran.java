package com.test.dto.translate;

import java.util.List;
import java.util.Map;

public class KingTran {

	private String word_name;
	private Integer is_CRI;
	private Map<Object,Object> exchange;
	private List<Object> symbols;
	private List<Object> items;
	
	public String getWord_name() {
		return word_name;
	}
	public void setWord_name(String wordName) {
		word_name = wordName;
	}
	public Integer getIs_CRI() {
		return is_CRI;
	}
	public void setIs_CRI(Integer isCRI) {
		is_CRI = isCRI;
	}
	public Map<Object, Object> getExchange() {
		return exchange;
	}
	public void setExchange(Map<Object, Object> exchange) {
		this.exchange = exchange;
	}
	public List<Object> getSymbols() {
		return symbols;
	}
	public void setSymbols(List<Object> symbols) {
		this.symbols = symbols;
	}
	public List<Object> getItems() {
		return items;
	}
	public void setItems(List<Object> items) {
		this.items = items;
	}
	
	
}
