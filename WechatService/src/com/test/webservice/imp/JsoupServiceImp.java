package com.test.webservice.imp;

import java.util.Date;
import java.util.Map;

import com.test.dto.Image;
import com.test.dto.Voice;
import com.test.dto.resp.ImageMessage;
import com.test.dto.resp.VoiceMessage;
import com.test.service.translate.TranslateService;
import com.test.service.translate.impl.TranslateServiceImpl;
import com.test.util.MessageUtil;
import com.test.util.UtilDate;
import com.test.util.WeChart;
import com.test.util.WeichatString;
import com.test.webservice.JsoupService;

public class JsoupServiceImp implements JsoupService {

	private TranslateService trans = new TranslateServiceImpl();

	@Override
	public String getVoice(Map<String, String> requestMap) throws Exception {
		// TODO Auto-generated method stub
		String respMessage = "请求处理异常，请稍候尝试！";

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// System.err.println(fromUserName);
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// System.err.println(toUserName);

		String date = UtilDate.getDate();

		Voice voice = new Voice();

		if (!WeChart.DAILY_VIOES.containsKey(date)) { // 查看 本地是否存在
			// 图片key,如果不存在则上传

			// trans.icibaEveryDay(date);
		}

		voice.setMediaId(WeChart.DAILY_VIOES.get(date));
		VoiceMessage voiceMessage = new VoiceMessage();
		voiceMessage.setToUserName(fromUserName);
		voiceMessage.setFromUserName(toUserName);
		voiceMessage.setCreateTime(new Date().getTime());
		voiceMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
		voiceMessage.setFuncFlag(0);
		voiceMessage.setVoice(voice);
		voiceMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);

		// respContent = jsoupService.getImage();
		// textMessage.setContent(respContent);
		respMessage = MessageUtil.voiceMessageToXml(voiceMessage);

		System.err.println(respMessage);

		return respMessage;
	}

	@Override
	public String getImage(Map<String, String> requestMap) throws Exception {
		// TODO Auto-generated method stub

		String respMessage = "请求处理异常，请稍候尝试！";

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// System.err.println(fromUserName);
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// System.err.println(toUserName);

		String date = UtilDate.getDate();

		Image image = new Image();

		if (!WeChart.DAILY_IMAGE.containsKey(date)) { // 查看 本地是否存在 图片key
			// ,如果不存在则上传
			trans.icibaEveryDay_image(date);
		}

		image.setMediaId(WeChart.DAILY_IMAGE.get(date));

		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setToUserName(fromUserName);
		imageMessage.setFromUserName(toUserName);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
		imageMessage.setFuncFlag(0);
		imageMessage.setImage(image);
		imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);

		// respContent = jsoupService.getImage();
		// textMessage.setContent(respContent);
		respMessage = MessageUtil.imageMessageToXml(imageMessage);

		 System.err.println(respMessage);

		return respMessage;

		// return "您发送的是图片消息！";
	}

	@Override
	public String getLink() throws Exception {
		// TODO Auto-generated method stub
		return "您发送的是链接消息！";
	}

	@Override
	public String getLocation() throws Exception {
		// TODO Auto-generated method stub
		return "您发送的是地理位置消息！";
	}

	@Override
	public String getSubscribe() throws Exception {
		// TODO Auto-generated method stub
		return WeichatString.CENTENT_SUBSCRIBE;
	}

	@Override
	public String getImage2(Map<String, String> requestMap) throws Exception {
		// TODO Auto-generated method stub
		String respMessage = "请求处理异常，请稍候尝试！";

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// System.err.println(fromUserName);
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// System.err.println(toUserName);

		String date = UtilDate.getDate();

		Image image = new Image();

		if (!WeChart.DAILY_IMAGE_2.containsKey(date)) { // 查看 本地是否存在 图片key
			// ,如果不存在则上传
			trans.icibaEveryDay_image2(date);
		}

		image.setMediaId(WeChart.DAILY_IMAGE_2.get(date));
		ImageMessage imageMessage = new ImageMessage();

		imageMessage.setToUserName(fromUserName);
		imageMessage.setFromUserName(toUserName);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
		imageMessage.setFuncFlag(0);
		imageMessage.setImage(image);
		imageMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);

		// respContent = jsoupService.getImage();
		// textMessage.setContent(respContent);
		respMessage = MessageUtil.imageMessageToXml(imageMessage);

		// System.err.println(respMessage);

		return respMessage;
	}

}
