package ch12;

public class StringEx {

	public static void main(String[] args) {
		// indexOf
		String greet = "안녕하세요";
		System.out.println(greet.indexOf("하"));
		// 단어의 포함 여부 (없으면 -1,  있으면 0 이상)
		if (greet.indexOf(".") > -1) { // 매개변수가 문자열에 있는지 여부 체크
			
		} else {
			
		}
		// 동적으로 어떤 값부터 짤라내야 되는 경우
		System.out.println(greet.substring(greet.indexOf("하")));
		
		String test = "abc";
		// 대문자로
		System.out.println(test.toUpperCase());
		// 소문자 : toLowerCase()
		
		// 앞/뒤 공백 제거
		test = "            a       bc                ";
		System.out.println(test);
		System.out.println(test.trim());
		
		// 모든 공백 제거
		System.out.println(test.replace(" ", ""));
		
		// 특정 문자열로 시작하는지 여부 (true/false로 리턴)
		test = "Mr.Lee";
		System.out.println(test.startsWith("Mr"));
		
		// 특정 문자열로 끝나는지 여부 (true/false로 리턴)
		System.out.println(test.endsWith("e"));
		
		// 문자열로 변환
		int a = 1;
		String a2 = String.valueOf(a);  // a+""; -> 가장 기본방법
		Integer b = 1;
		String b2 = String.valueOf(b);  // b+"";
		
		// 퀴즈
		String fileName = "2025.04.10_시간표.xlsx";
		// 파일명 변경 System.currentTimeMillis -> 17
		// 확장자는 그대로 두고 파일명만 변경
		int dotIndex = fileName.lastIndexOf(".");
		String extension = fileName.substring(dotIndex);
		
		String newFileName = String.valueOf(System.currentTimeMillis()) + extension;
		
		// 강사님
		String newFileName2 = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		
		System.out.println(newFileName);
		System.out.println(newFileName2);
		
		test.toUpperCase().replace(" ", "").substring(2).indexOf(1);
		
		// append / toString
		StringBuilder sb = new StringBuilder();
		sb.append(1).append(2).append(3);
		String name = sb.toString();
		System.out.println(sb);
		
		System.out.println(get("id", 30));
	}
	
	// 아이디와 나이(정수, 문자)를 입력받아 합쳐서 리턴
	public static String get(String id, Object age) {
		return id + age;
	}

}
