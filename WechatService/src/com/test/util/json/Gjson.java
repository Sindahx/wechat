package com.test.util.json;

import com.google.gson.Gson;

public class Gjson {

	public static <T> T getPerson(String jsonString, Class<T> cls) {
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}

	public static String setPerson(String jsonString, Class cls) {
		String str = null;
		try {
			Gson gson = new Gson();
			str = gson.toJson(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return str;
	}
}
