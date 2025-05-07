package ch19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEx {

	public static void main(String[] args) {
		/* 
		 * 웹상의 주소(URL)로 요청 후 응답 받은 데이터(html, json, text...)를 입력 받아
		 * 콘솔에 출력 
		 */
		
		URL url = null;
		BufferedReader br = null;
		try {
			url = new URL("https://www.work24.go.kr/cm/main.do");
			System.out.println(url.getHost());
			System.out.println(url.getPath());
			System.out.println(url.getProtocol());
			System.out.println(url.getPort());
			
//			br = new BufferedReader(new InputStreamReader(url.openStream()));
//			
//			String readLine = "";
//			while ((readLine = br.readLine()) != null) {
//				System.out.println(readLine);
//			}
			
			String text = "안녕하세요";
			String text2 = URLEncoder.encode(text, "UTF-8");
			System.out.println(text2); // %EC%95%88%EB%85%95%ED%95%98%EC%84%B8%EC%9A%94
			String text3 = URLDecoder.decode(text2, "UTF-8");
			System.out.println(text3); // 안녕하세요
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
