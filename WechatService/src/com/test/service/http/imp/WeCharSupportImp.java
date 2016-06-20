package com.test.service.http.imp;

import com.test.dto.request.AccessToken;
import com.test.dto.request.UploadRequest;
import com.test.service.http.HttpRequestService;
import com.test.service.http.WeCharSupport;
import com.test.util.FileUpload;
import com.test.util.UtilDate;
import com.test.util.WeChart;
import com.test.util.WeichatString;
import com.test.util.json.Gjson;

public class WeCharSupportImp implements WeCharSupport {

	private HttpRequestService http = new HttpRequestServiceImp();

	@Override
	public String getAccessToken() throws Exception {
		// TODO Auto-generated method stub

		String grant_type = WeichatString.GRANT_TYPE;
		String appid = WeichatString.APPID;
		String secret = WeichatString.SECRET;

		String url = WeichatString.WECHAR_ACCESS_TOKEN;
		String parame = "grant_type=" + grant_type + "&appid=" + appid + "&secret=" + secret;

		String access = http.sendGet(url, parame);

		AccessToken token = Gjson.getPerson(access, AccessToken.class);

		WeChart.ACCESSTOKEN = token.getAccess_token();
		// http.sendGet(url, parame);
		return token.getAccess_token();
	}

	@Override
	public String uploadMedio(String type, String filePath, String token, String optType) throws Exception {
		// TODO Auto-generated method stub

		String parame = "access_token=" + token + "&type=" + type;
		String url = WeichatString.WECHAR_UPLOAD + parame;

		String json = FileUpload.send(url, filePath);

		String date = UtilDate.getDate();

		UploadRequest upload = Gjson.getPerson(json, UploadRequest.class);
		if (upload.getErrcode() == "") {
			return "error";
		}
		if (!optType.equals(null) && optType.equals("pic_1")) {

			// WeChart.DAILY_IMAGE.put(date, upload.getMedia_id());
			WeChart.DAILY_IMAGE.put(date, upload.getMedia_id());
		}

		if (!optType.equals(null) && optType.equals("pic_2")) {
			WeChart.DAILY_IMAGE_2.put(date, upload.getMedia_id());
		}
		// if (type.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
		// // WeChart.DAILY_IMAGE.put(date, upload.getMedia_id());
		// WeChart.DAILY_VIOES.put(date,upload.getMedia_id());
		// }

		return "success";
	}

	public static void main(String[] args) {

		// String token =
		// "f-kCH0KdaIx9ll1XxVSqcndTKmLpEToZPgW28kzgYgiRK-KVzOgiuNcBqSrSgYK87RruKf1TIRod60xi2h-ZggEl6uVmySQofjkx0yvF1KQMIUbAJARNZ";
		// String type = "image";
		// String filePath = "http://cdn.iciba.com/news/word/2015-12-18.jpg";
		WeCharSupportImp weichar = new WeCharSupportImp();

		try {
			// token = weichar.getAccessToken();
			// System.err.println(token);
			// System.err.println(weichar.uploadMedio(type, filePath, token));
			System.err.println(weichar.getAccessToken());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
