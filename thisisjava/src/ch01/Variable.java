package ch01;

import java.util.HashMap;
import java.util.Map;

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 변수 선언
		// 타입 변수명;
		int a;
		// 대입
		a = 10;
		System.out.println(a);
		
		// 변수 선언 + 초기화
		int b = 20;
		// System.out.println(b);
		
		// 초기화 하지 않으면 사용 불가
		int c; // 선언
//		System.out.println(c); // 에러 => The local variable c may not have been initialized. 해결 방법 => initialize variable
		
		// 다른 타입 대입 불가
//		int d = 3.14; // 정수가 아닌 다른 타입은 에러 (Type mismatch: cannot convert from double to int)
		// 동일한 타입
		double d = 3.14;
		
		double e = 3; // 정수 -> 실수 자동 변환
		System.out.println(e); // 3.0
		
		Variable v = new Variable();
		Object obj = v; // 자동형변환
//		System.out.println();
		
		// 타입 == 자료형(데이터 타입)
		// 기본 자료형 | 참조 자료형
		// 기본 자료형: 정수, 실수, 문자(애매), 논리
		// 참조 자료형: 배열, 클래스, 인터페이스 ...
		// 참조 자료형 예시
		Variable f;
		
		// byte 타입의 범위 -128~127
		byte g = -128;
		
		// 제일 중요한, 가장 자주 사용됨
		int h = -33000;
		
		// 연산 시 int로 변환
//		byte i = g + 1; // -127
		
		// 정수 쓸거야!! : int -> 21억이 넘어? -> long 
		
		// long = int
		long j = 10; // 자동 형변환
		long k = 10L; // ilI1
//		int l = 10L;
		
		// 문자
		char m = 'A'; // 65
		int o = m + 1;
		System.out.println(o); // 계산이 된다..!
		
		// 문자열
		String n = "A";
		
		// 실수 (소수점이 있는)
		// double
		
		// *** 가본자료형(숫자) 정리
		// int > long > double
		
		// 논리 타입
		// true / false
		boolean p = true;
		
		int x = 10;
		boolean result = x == 20;
		System.out.println(result);
		
		// escape "저는 "홍길동" 입니다."
		String greet = "저는 \"홍길동\" \\입니다.";
		System.out.println(greet);
		
		String greet2 = """
				저는
				홍길동
				입니다.
				""";
		
		// 타입추론(JDK11)
		var age = "30세";
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 형변환 : 타입 변환
		// 자동형변환 : 작은 범위의 값이 넓은 범위의 변수로 대입
		double q = a;  // int → double
		// 강제형변환 :  넓은 범위의 값이 작은 범위의 변수로 대입
		a = (int)q; // 바꾸고자 하는 타입 지정
		
		double pi = 3.14;
		int pi_int = (int)pi;
		System.out.println(pi_int); // 소수점 유실
		
		// 변수의 사용 범위(scope)
		// 변수가 선언된 위치(중괄호블럭)에서만 사용 가능
		if (true) {
			int xxx = 0;
			System.out.println(xxx);
		}
//		System.out.println(xxx);
		
		
	}

}
