package com.test.service.translate.impl;

import java.net.URLEncoder;

import com.test.dto.translate.DailySentence;
import com.test.dto.translate.KingTran;
import com.test.dto.translate.Youdao;
import com.test.service.http.HttpRequestService;
import com.test.service.http.WeCharSupport;
import com.test.service.http.imp.HttpRequestServiceImp;
import com.test.service.http.imp.WeCharSupportImp;
import com.test.service.translate.TranslateService;
import com.test.util.MessageUtil;
import com.test.util.WeChart;
import com.test.util.WeichatString;
import com.test.util.json.Gjson;

public class TranslateServiceImpl implements TranslateService {

	private HttpRequestService http = new HttpRequestServiceImp();
	private WeCharSupport wechat = new WeCharSupportImp();

	@Override
	public Youdao youdao(String content) throws Exception {
		// TODO Auto-generated method stub

		String url = WeichatString.YOUDAO + URLEncoder.encode(content, "UTF-8");

		String translate = http.sendGet(url);

		Youdao youdao = Gjson.getPerson(translate, Youdao.class);

		return youdao;

	}

//	@Override
	public DailySentence icibaEveryDay(String date) throws Exception {
		// TODO Auto-generated method stub

		String translate = http.sendGet(WeichatString.ICIBA + date);

		DailySentence daily = Gjson.getPerson(translate, DailySentence.class);

		// WeChart.DAILY_IMAGE.put(date, daily.getFenxiang_img()); // 每日一句图片id;
//		WeChart.DAILY_IMAGE.put(date, daily.getFenxiang_img()); // 每日一句图片id;
		if (WeChart.ACCESSTOKEN == null) {
			wechat.getAccessToken();
		}

		// String medio_image =
		String msg = wechat.uploadMedio(MessageUtil.REQ_MESSAGE_TYPE_IMAGE, daily.getFenxiang_img(), WeChart.ACCESSTOKEN, null);
		if (msg.equals("error")) {
			wechat.getAccessToken();
			wechat.uploadMedio(MessageUtil.REQ_MESSAGE_TYPE_IMAGE, daily.getFenxiang_img(), WeChart.ACCESSTOKEN, null);
		}
		// WeChart.DAILY_SENTANS.put(date, daily.getContent()); // 每日一句,English
		// WeChart.DAILY_TRANSLATE.put(date, daily.getNote()); // 每日一句,中文
		WeChart.DAILY_SENTANS.put(date, daily.getContent()); // 每日一句,English
		WeChart.DAILY_TRANSLATE.put(date, daily.getNote()); // 每日一句,中文
		// WeChart.Daily_vioes.put(date, daily.getTts()); // 每日一句,声音;
		wechat.uploadMedio(MessageUtil.REQ_MESSAGE_TYPE_IMAGE, daily.getPicture2(), WeChart.ACCESSTOKEN, "pic_2");

		return daily;
	}

	@Override
	public KingTran kingTranslate(String content) throws Exception {
		// TODO Auto-generated method stub
		String url = WeichatString.CONN_TRANF_ + URLEncoder.encode(content, "UTF-8");

		String translate = http.sendGet(url);

		// System.err.println(translate);

		KingTran king = Gjson.getPerson(translate, KingTran.class);

		return king;
	}

	@Override
	public DailySentence icibaEveryDay_content(String date) throws Exception {
		// TODO Auto-generated method stub
		String translate = http.sendGet(WeichatString.ICIBA + date);

		DailySentence daily = Gjson.getPerson(translate, DailySentence.class);

		WeChart.DAILY_SENTANS.put(date, daily.getContent()); // 每日一句,English
		WeChart.DAILY_TRANSLATE.put(date, daily.getNote()); // 每日一句,中文

		return daily;
	}

	@Override
	public DailySentence icibaEveryDay_image(String date) throws Exception {
		// TODO Auto-generated method stub
		String translate = http.sendGet(WeichatString.ICIBA + date);

		DailySentence daily = Gjson.getPerson(translate, DailySentence.class);

		if (WeChart.ACCESSTOKEN == null) {
			wechat.getAccessToken();
		}

		wechat.uploadMedio(MessageUtil.REQ_MESSAGE_TYPE_IMAGE, daily.getFenxiang_img(), WeChart.ACCESSTOKEN, "pic_1");

		return daily;
	}

	@Override
	public DailySentence icibaEveryDay_image2(String date) throws Exception {
		// TODO Auto-generated method stub
		String translate = http.sendGet(WeichatString.ICIBA + date);

		DailySentence daily = Gjson.getPerson(translate, DailySentence.class);

//		WeChart.DAILY_IMAGE.put(date, daily.getFenxiang_img()); // 每日一句图片id;
		if (WeChart.ACCESSTOKEN == null) {
			wechat.getAccessToken();
		}
		wechat.uploadMedio(MessageUtil.REQ_MESSAGE_TYPE_IMAGE, daily.getPicture2(), WeChart.ACCESSTOKEN, "pic_2");

		return daily;
	}

}
