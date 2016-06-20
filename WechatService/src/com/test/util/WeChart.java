package com.test.util;

import java.util.HashMap;
import java.util.Map;

public class WeChart {

	public static String ACCESSTOKEN = null; // 微信token

	// public static String MEDIAID_IMAGE =
	// "HtgaCGp7CCubBI6CKEh_kEEDdsNkbDnraRaMsntAzqco-TW8ok5QGIDpjLhRoNf9";
	// //每日一句id;

//	public static String DAILY_IMAGE = null;
//	public static String DAILY_SENTANS = null;
//	public static String DAILY_TRANSLATE = null;
//	public static String DAILY_VIOES = null;
	public static Map<String, String> DAILY_IMAGE = new HashMap<String, String>(); // 每日一句图片id;
	public static Map<String, String> DAILY_IMAGE_2 = new HashMap<String, String>(); // 每日一句图片id;
	public static Map<String, String> DAILY_SENTANS = new HashMap<String, String>(); // 每日一句,English
	public static Map<String, String> DAILY_TRANSLATE = new HashMap<String, String>(); // 每日一句,中文
	public static Map<String, String> DAILY_VIOES = new HashMap<String, String>(); // 每日一句,声音;
	// public static String getACCESSTOKEN() {
	// return ACCESSTOKEN;
	// }
	//
	// public static void setACCESSTOKEN(String aCCESSTOKEN) {
	// ACCESSTOKEN = aCCESSTOKEN;
	// }

}
