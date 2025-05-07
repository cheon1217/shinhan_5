package ch15.sec04.exam03;

import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExample {

	public static void main(String[] args) throws Exception {
		// Properties 컬렉션 생성
		Properties properties = new Properties();
		
		// PropertiesExample.class와 동일한 ClassPath에 있는 database.properties 파일 로드
		properties.load(PropertiesExample.class.getResourceAsStream("database.properties"));
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String admin = properties.getProperty("admin");
		
		System.out.println("driver: " + driver);
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		System.out.println("admin: " + admin);
		
		System.out.println("------------------------------------");
		ResourceBundle rb = ResourceBundle.getBundle("database");
		System.out.println("driver: " + rb.getString(driver));
		System.out.println("url: " + rb.getString(url));
		System.out.println("username: " + rb.getString(username));
		System.out.println("password: " + rb.getString(password));
		System.out.println("admin: " + rb.getString(admin));
	}

}
