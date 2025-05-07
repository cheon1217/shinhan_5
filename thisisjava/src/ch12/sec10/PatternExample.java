package ch12.sec10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if (result) System.out.println("정규식과 일치");
		else 	      System.out.println("정규식과 일치하지 않음");
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@mycompanycom";
		result = Pattern.matches(regExp, data);
		if (result) System.out.println("정규식과 일치");
		else 	      System.out.println("정규식과 일치하지 않음");
		
		// 컴파일
		Pattern p = Pattern.compile("b[a-z]*"); // b로 시작하는 영문 소문자 0개 이상
		Matcher m = p.matcher("banana");
		System.out.println(m.matches());
		System.out.println(p.matcher("batman").matches());
		
		// 미리 컴파일
		p = Pattern.compile("(0\\d{1,2})-(\\d{3,4})-(\\d{4})"); // ()는 그룹핑
		
		// 추출
		String source = "안녕하세요 저는 홍길동입니다. 어쩌고 저쩌고.. 제 전화번호는 010-1234-5678입니다. 그리고 제 친구 번호도 018-9876-5432";
		m = p.matcher(source);
		while (m.find()) {
//			System.out.println("찾았다"); // 확인용
			System.out.println(m.group());
			System.out.println(m.group(1) + "-" + m.group(2) + "-" + m.group(3));
			System.out.println();
		}
	}

}
