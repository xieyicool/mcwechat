package com.mchr.wechat.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MCNet {

	public static String  Get(String requestUrl) throws Exception {
		HttpURLConnection conn;
		HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
		// Prepare SSL Context
		TrustManager[] tm = { ignoreCertificationTrustManger };
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, tm, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		// SSLSocketFactory ssf = sslContext.getSocketFactory();

		URL url = new URL(requestUrl);
		HttpsURLConnection sslConn = (HttpsURLConnection) url.openConnection();
		// sslConn.setSSLSocketFactory(ssf);
		conn = sslConn;

		conn.setInstanceFollowRedirects(false);
		conn.setDoInput(true);

		// if ("POST".equalsIgnoreCase("")) {
		// conn.setDoOutput(true);
		// }

		conn.setReadTimeout(10000);
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		InputStream is = conn.getInputStream();
		
		String s = streamToStr(is);

		return s;
	}
	
	public static String  Post(String requestUrl, String content) throws Exception {
		HttpURLConnection conn;
		HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
		// Prepare SSL Context
		TrustManager[] tm = { ignoreCertificationTrustManger };
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, tm, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		// SSLSocketFactory ssf = sslContext.getSocketFactory();

		URL url = new URL(requestUrl);
		HttpsURLConnection sslConn = (HttpsURLConnection) url.openConnection();
		// sslConn.setSSLSocketFactory(ssf);
		conn = sslConn;

		conn.setInstanceFollowRedirects(false);
		conn.setDoInput(true);

		// if ("POST".equalsIgnoreCase("")) {
		conn.setDoOutput(true);
		// }

		conn.setReadTimeout(20000);
		conn.setConnectTimeout(5000);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
		OutputStream os = conn.getOutputStream();
		os.write(content.getBytes("UTF-8"));
		os.flush();
		
		InputStream is = conn.getInputStream();
		
		String s = streamToStr(is);

		return s;
	}
	
	public static String streamToStr(InputStream is) {
		try {
			// 字节的输出流
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			// 定义读取长度
			int len = 0;
			// 定义缓冲区
			byte buffer[] = new byte[1024];
			// 从输入流中读取，并写入os对象
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
			// 关闭流
			is.close();
			os.close();
			// 写到字节流
			return new String(os.toByteArray(), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
		public boolean verify(String s, SSLSession sslsession) {
			return true;
		}
	};
	/**
	 * Ignore Certification
	 */
	private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {
		// private X509Certificate[] certificates;

		@Override
		public void checkClientTrusted(X509Certificate certificates[], String authType) throws CertificateException {
			// if(this.certificates == null){
			// this .certificates = certificates;
			// System.out.println("init at checkClientTrusted");
			// }
		}

		@Override
		public void checkServerTrusted(X509Certificate[] ax509certificate, String s) throws CertificateException {
			// if(this.certificates == null){
			// this.certificates = ax509certificate;
			// System.out.println("init at checkServerTrusted");
			// }
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
	};

}
