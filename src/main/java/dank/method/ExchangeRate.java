package main.java.dank.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRate {
	
	public static String callURL(String myURL) {

		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;

		// error : Caused by: javax.net.ssl.SSLPeerUnverifiedException: Hostname not
		// verified:
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				// Ư�� hostname�� ������ ���ִ� ����
				return true;
			}
		};
		//
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				// charset ���� ������ ���ڵ��� ����� urlConn.getInputStream�� ���ڽ�Ʈ������ ��ȯ ��ü�� ����.
				BufferedReader bufferedReader = new BufferedReader(in);
				// �־��� ���� �Է� ��Ʈ�� inputStream�� ���� �⺻ ũ���� ���۸� ���� ��ü�� ����.
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception URL:" + myURL, e);
		}
		return sb.toString();
	}

	public String exchangeRateJson() {
		String exchangeRate = callURL("http://fx.kebhana.com/FER1101M.web");
		return exchangeRate;
	}
}
