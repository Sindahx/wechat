import com.test.dto.translate.DailySentence;
import com.test.dto.translate.Youdao;
import com.test.service.http.HttpRequestService;
import com.test.service.http.imp.HttpRequestServiceImp;
import com.test.service.translate.TranslateService;
import com.test.service.translate.impl.TranslateServiceImpl;
import com.test.util.UtilDate;


public class test {
	
	private TranslateService translate = new TranslateServiceImpl();
	
	HttpRequestService http = new HttpRequestServiceImp();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		translate
		new test().get();
		
	}

	private void get(){
		try {
//			Youdao youdao= translate.youdao("你好");
			
//			DailySentence daily = translate.icibaEveryDay(UtilDate.getDate());
//			System.err.println(daily.getContent());
			
//			http.sendPost("http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE", param);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
