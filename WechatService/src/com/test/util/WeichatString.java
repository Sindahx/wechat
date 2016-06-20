package com.test.util;

public class WeichatString {

	// 有道接口
	public static final String YOUDAO = "http://fanyi.youdao.com/openapi.do?keyfrom=sindaweb&key=502897631&type=data&doctype=json&version=1.1&q=";

	// 爱词霸每日一句接口
	public static final String ICIBA = "http://open.iciba.com/dsapi/?date=";

	// 爱词霸翻译接口
	public static final String CONN_TRANF = "http://www.iciba.com/"; // 爱词霸接口

	// 爱词霸翻译接口
	public static final String CONN_TRANF_ = "http://dict-co.iciba.com/api/dictionary.php?key=849174EF7652D13D99376A5F27736E18&type=json&w=";

	// 获取微信token接口
	public static final String WECHAR_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

	// 微信上传文件接口
	public static final String WECHAR_UPLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/upload?";

	public static Integer TRANSLATE = 1;
	public static Integer TRANSLATE_YOUDAO = 1;
	public static Integer TRANSLATE_KING = 2;

	public static final String TRANSLATE_YOUDAO_youdao = "translate_youdao";
	public static final String TRANSLATE_YOUDAO_king = "translate_king";

	public static final String GRANT_TYPE = "client_credential";

	public static final String APPID = "wx47f5990f508ca575"; // appid
	public static final String SECRET = "d4624c36b6795d1d99dcf0547af5443d"; // appsecret

	public static final String TOKEN = "1111111111"; // token

	public static final String CONTENT_STERN = "\n[翻译来自有道,仅供参考]";
	public static final String CONTENT_STERN_KING = "\n[翻译来自爱词霸,仅供参考]";
	// public static final String SEARCH_STERN = "免费申请课程";
	//
	// public static final String SEARCH_STERN_2 = "免费Hi-";

	public static final String CENTENT_SUBSCRIBE = "Thank you for your follow!";

	// public static final String STR = "每日一句";
	// public static final String STR1 = "每日";
	// public static final String STR2 = "每天";
	// public static final String STR3 = "句子";
	// public static final String STR4 = "一句";

	public static final String FENXIANG_IMG = "1";
	public static final String CONTENT = "2";
	public static final String TTS = "4";
	public static final String PICTURE2 = "3";

}
