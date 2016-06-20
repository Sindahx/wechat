package com.test.action.imp;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.test.action.CrazyService;
import com.test.dto.resp.TextMessage;
import com.test.util.MessageUtil;
import com.test.util.WeichatString;
import com.test.webservice.JsoupService;
import com.test.webservice.TextService;
import com.test.webservice.imp.JsoupServiceImp;
import com.test.webservice.imp.TextServiceImp;

public class CrazyServiceImp implements CrazyService {

	private JsoupService jsoupService = new JsoupServiceImp(); // 消息处理
	private TextService textService = new TextServiceImp();

	@Override
	public String processRequest(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub

		String respMessage = null;

		// 默认返回的文本消息内容
		String respContent = "请求处理异常，请稍候尝试！";

		// xml请求解析
		Map<String, String> requestMap = MessageUtil.parseXml(request);

		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// System.err.println(fromUserName);
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// System.err.println(toUserName);
		// 消息类型
		String msgType = requestMap.get("MsgType");
		// System.err.println(msgType);

		String content = requestMap.get("Content");
		// System.err.println(content);

		// String token = requestMap.get("echostr");
		// System.err.println(token);

		// 回复文本消息

		// 文本消息
		if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			if (content.equals(WeichatString.TRANSLATE_YOUDAO_youdao)) {
				WeichatString.TRANSLATE = 1;
			}
			if (content.equals(WeichatString.TRANSLATE_YOUDAO_king)) {
				WeichatString.TRANSLATE = 2;
			}

			if (content.equals(WeichatString.FENXIANG_IMG)) { // 获取图文 照片

				respContent = jsoupService.getImage(requestMap);
				return respContent;

			} else if (content.equals(WeichatString.CONTENT)) { // 文字
				respContent = textService.getDailySentence(); //
			}
//			else if (content.equals(WeichatString.TTS)) { // 声音
//				respContent = jsoupService.getVoice(requestMap);
//				return respContent;
//			} 
			else if (content.equals(WeichatString.PICTURE2)) { // 单独图片

				respContent = jsoupService.getImage2(requestMap);
				return respContent;
				
			} else {

				if (WeichatString.TRANSLATE == WeichatString.TRANSLATE_YOUDAO) {
					respContent = textService.getTextYoudao(content) + WeichatString.CONTENT_STERN;
				}
				if (WeichatString.TRANSLATE == WeichatString.TRANSLATE_KING) {
					respContent = textService.getTextKing(content) + WeichatString.CONTENT_STERN_KING;
				}
			}

			textMessage.setContent(respContent);
			respMessage = MessageUtil.textMessageToXml(textMessage);
			return respMessage;
		}
		// 图片消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {

			respContent = jsoupService.getImage(requestMap);

			return respContent;

		}
		// 地理位置消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			respContent = jsoupService.getLocation();
		}
		// 链接消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
			respContent = jsoupService.getLink();
		}
		// 音频消息
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {

			String voice = requestMap.get("Recognition");

			// String res = textService.getTextYoudao(content);
			if (WeichatString.TRANSLATE == WeichatString.TRANSLATE_YOUDAO) {
				respContent = textService.getTextYoudao(content) + WeichatString.CONTENT_STERN;
			}
			if (WeichatString.TRANSLATE == WeichatString.TRANSLATE_KING) {
				respContent = textService.getTextKing(content) + WeichatString.CONTENT_STERN_KING;
			}

			respContent = voice + "\r\n" + respContent + WeichatString.CONTENT_STERN;

			// respContent = "您发送的是音频消息！";
		}
		// 事件推送
		else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			String eventType = requestMap.get("Event");
			// 订阅
			if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
				respContent = jsoupService.getSubscribe();
			}
			// 取消订阅
			else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
				// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			}
			// 自定义菜单点击事件
			else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
				// TODO 自定义菜单权没有开放，暂不处理该类消息
			}
		}

		// textMessage.setContent(respContent);
		// respMessage = MessageUtil.textMessageToXml(textMessage);

		return respMessage;
	}
}
