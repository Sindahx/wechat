import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class testUpload4 {
	
	public static void main(String[] args) {

		String optType= "8";
		String[] file = new String[] {"E:/5/10018051444650132790.png" };
		String urlpath = "http://192.168.1.34:8080/fabao-file/upload.action";
		String data = "optType="+optType+"&userToken=jfsljfkldjlf&userUid=105458";

		try {
			urlpath = urlpath + "?" + data;

			String boundary = "Boundary-b1ed-4060-99b9-fca7ff59c113"; // Could  be  any  string

			String Enter = "\r\n";

			URL url = new URL(urlpath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

			conn.connect();

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

			FileInputStream fis = null;

			for (int i = 0; i < file.length; i++) {

				File xml = new File(file[i]);
				fis = new FileInputStream(xml);

				String part1 = Enter + "--" + boundary + Enter + "Content-Type: application/octet-stream" + Enter
						+ "Content-Disposition: form-data; filename=\"" + xml.getName() + "\"; name=\"file\"" + Enter + Enter;

				byte[] xmlBytes = new byte[fis.available()];
				fis.read(xmlBytes);

				dos.writeBytes(part1);
				dos.write(xmlBytes);
			}
			String part3 = "hk" + Enter + "--" + boundary + "--";

			dos.writeBytes(part3);

			dos.flush();
			dos.close();
			fis.close();

			String result = null;
			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = null;
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
			System.err.println(result);
			// System.out.println("status code: "+conn.getResponseCode());
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
