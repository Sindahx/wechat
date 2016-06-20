package com.test.webservice.imp;

import java.util.List;
import java.util.Map;

import com.test.dto.translate.KingTran;
import com.test.dto.translate.Youdao;
import com.test.service.translate.TranslateService;
import com.test.service.translate.impl.TranslateServiceImpl;
import com.test.util.UtilDate;
import com.test.util.WeChart;
import com.test.webservice.TextService;

public class TextServiceImp implements TextService {

	TranslateService translate = new TranslateServiceImpl();

	@SuppressWarnings("unchecked")
	@Override
	public String getTextYoudao(String context) throws Exception {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();

		Youdao youdao = translate.youdao(context);

		String query = youdao.getQuery();
		List<Object> translation = youdao.getTranslation();
		List<Object> web = youdao.getWeb();
		Map<Object, Object> basic = youdao.getBasic();

		sb.append(query + "\n");

		if (basic != null) {
			// if (basic.containsKey("phonetic")) {
			// sb.append(basic.get("phonetic") + "\n");
			// }
			if (basic.containsKey("uk-phonetic")) {
				sb.append("英音: [" + basic.get("uk-phonetic") + "]\n");
			}
			if (basic.containsKey("us-phonetic")) {
				sb.append("美音: [" + basic.get("us-phonetic") + "]\n");
			}
			if (basic.containsKey("explains")) {
				List<Object> explains = (List<Object>) basic.get("explains");
				for (Object exp : explains) {
					sb.append(exp + "\n");
				}
			}
		}

		for (Object str : translation) {
			sb.append(str + "\n");
		}
		if (web != null) {
			for (Object object : web) {
				sb.append("-----------------\n");
				Map<Object, Object> map = (Map<Object, Object>) object;
				// System.err.println(map.get("key"));
				sb.append(map.get("key") + "\n");
				List<Object> value = (List<Object>) map.get("value");
				for (Object val : value) {
					// System.err.println(val);
					sb.append(val + "\n");
				}
			}
		}

		return sb.toString();
	}

	@Override
	public String getDailySentence() throws Exception {
		// TODO Auto-generated method stub

		String date = UtilDate.getDate();

		// DailySentence daily = translate.icibaEveryDay(date);

		if (!WeChart.DAILY_SENTANS.containsKey(date)) { // 查看 本地是否存在
			// 图片key,如果不存在则上传

			translate.icibaEveryDay_content(date);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[每日一句]\r\n");
		// sb.append(daily.getContent() + "\r\n");
		sb.append(WeChart.DAILY_SENTANS.get(date) + "\r\n");
		// sb.append(daily.getNote());
		sb.append(WeChart.DAILY_TRANSLATE.get(date));
		return sb.toString();
	}

	@Override
	public String getTextKing(String context) throws Exception {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();

		KingTran king = translate.kingTranslate(context);

		// List<Object> symbols = king.getSymbols();
		Map<Object, Object> ymbols = (Map<Object, Object>) king.getSymbols().get(0); // 包含了音标语音和parts

		if (ymbols.containsKey("ph_en")) {
			// System.err.println("英音: [" + ymbols.get("ph_en") + "]");
			sb.append("英音: [" + ymbols.get("ph_en") + "]\n");
		}
		if (ymbols.containsKey("ph_am")) {
			// System.err.println("美音: [" + ymbols.get("ph_am") + "]");
			sb.append("英音: [" + ymbols.get("ph_en") + "]\n");
		}

		if (ymbols.containsKey("parts")) {

			List<Object> parts = (List<Object>) ymbols.get("parts"); // 包含了词性
			// 和解释

			for (Object object : parts) {
				Map<Object, Object> O1 = (Map<Object, Object>) object;
				if (O1.containsKey("part")) {
					// System.err.print(O1.get("part") + " ");
					sb.append(O1.get("part"));
					Object means = O1.get("means");
					// System.err.println(means);
					sb.append(means + " \n");
				}
				if (O1.containsKey("part_name")) {
					List<Object> means = (List<Object>) O1.get("means");
					for (Object object2 : means) {
						Map<Object, Object> map = (Map<Object, Object>) object2;
						// System.err.println(map.get("word_mean"));
						sb.append(map.get("word_mean") + " \n");
					}
				}
			}
		}
		// System.err.print("\n");
		sb.append("\n");

		Map<Object, Object> exchange = king.getExchange();
		if (exchange != null) {

			if (exchange.containsKey("word_pl") && !exchange.get("word_pl").equals("")) {
				// System.err.println("复数: " + ((List<Object>)
				// exchange.get("word_pl")).get(0));
				sb.append("复数: " + ((List<Object>) exchange.get("word_pl")).get(0) + " \n");
			}
			if (exchange.containsKey("word_past") && !exchange.get("word_past").equals("")) {
				// System.err.println("过去式: " + ((List<Object>)
				// exchange.get("word_past")).get(0));
				sb.append("过去式: " + ((List<Object>) exchange.get("word_past")).get(0) + " \n");
			}
			if (exchange.containsKey("word_done") && !exchange.get("word_done").equals("")) {
				sb.append("过去分词: " + ((List<Object>) exchange.get("word_done")).get(0) + " \n");
				// System.err.println("过去分词: " + ((List<Object>)
				// exchange.get("word_done")).get(0));
			}
			if (exchange.containsKey("word_ing") && !exchange.get("word_ing").equals("")) {
				// System.err.println("现在分词: " + ((List<Object>)
				// exchange.get("word_ing")).get(0));
				sb.append("现在分词: " + ((List<Object>) exchange.get("word_ing")).get(0) + " \n");
			}
			if (exchange.containsKey("word_third") && !exchange.get("word_third").equals("")) {
				// System.err.println("第三人称单数: " + ((List<Object>)
				// exchange.get("word_third")).get(0));
				sb.append("第三人称单数: " + ((List<Object>) exchange.get("word_third")).get(0) + " \n");
			}
		}
		// System.err.println(king.toString());

		System.err.println(sb.toString());

		return sb.toString();
	}

	public static void main(String[] args) {
		try {
			new TextServiceImp().getTextKing("有时候");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Override
	// public String getText(String context) throws Exception {
	// // TODO Auto-generated method stub
	// // context = new String(context.getBytes("UTF-8"));
	// context = URLEncoder.encode(context, "UTF-8");
	// String url = WeichatString.CONN_TRANF + context;
	// // long start = System.currentTimeMillis();
	//
	// Document doc = Jsoup.connect(url).timeout(5000).get();
	//
	// Elements elem = doc.getElementsByTag("div");
	// // System.err.println("Title is:" + elem.text());
	// String text = elem.text();
	// System.out.println(text);
	//
	// int stern = text.length();
	//
	// // if (text.indexOf(WeichatString.SEARCH_STERN) != -1) {
	// // stern = text.indexOf(WeichatString.SEARCH_STERN);
	// // }
	// // if (text.indexOf(WeichatString.SEARCH_STERN_2) != -1) {
	// // stern = text.indexOf(WeichatString.SEARCH_STERN_2);
	// // }
	//
	// if (text.contains("英 [")) {
	//
	// String jieguo = text.substring(text.indexOf("英 ["), stern);
	// // String[] list = jieguo.split("[a-zA-Z]+\\.|:|复数:");
	// jieguo = ReplaceString.replace(jieguo); // 处理字符串
	//
	// System.err.println(jieguo);
	// return jieguo;
	// } else {
	//
	// int start = 0;
	//
	// // if (text.indexOf(WeichatString.SEARCH_START) != -1) {
	// // start = text.indexOf(WeichatString.SEARCH_START)+17;
	// // return text.substring(start, stern);
	// // }
	// //
	// // if (text.indexOf(WeichatString.SEARCH_START_2) != -1) {
	// // start = text.indexOf(WeichatString.SEARCH_START_2)+7;
	// // return text.substring(start, stern);
	// // }
	// //
	// // if (text.indexOf(WeichatString.SEARCH_START_3) != -1) {
	// // start = text.indexOf(WeichatString.SEARCH_START_3)+12;
	// // return text.substring(start, stern);
	// // }
	//
	// // String jieguo =
	// // System.err.println(jieguo);
	// return text.substring(start, stern);
	// }
	// }
}
