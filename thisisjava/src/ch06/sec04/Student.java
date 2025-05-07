package ch06.sec04;

public class Student {
	String name;
	
	// 생성자가 없으면 컴파일 시 기본 생성자 추가
	// 생성자 (리턴타입이 없고, 이름이 클래스명과 동일)
	Student(String n) {
		name = n;
		System.out.println("생성자 실행");
	}
	// 다른 생성자, 이것을 자바에서는 overload(ing)라 함
	// 기본 생성자 (매개변수가 없는)
	Student() {
		
	}
	
	void method1() {
		String name = null; // 변수(local variable, 지역변수)
		System.out.println(name); // 변수 출력
		System.out.println(this.name); // 필드 출력
	}
	
	String method2() {
		System.out.println(name); // 필드 출력
		return name;
	}

}
