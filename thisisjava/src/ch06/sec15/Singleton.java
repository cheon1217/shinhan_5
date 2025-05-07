package ch06.sec15;

public class Singleton {
	// 외부에서 접근 금지, 정적 -> 메모리에 로드
	// Singleton 객체가 저장되어 있는 주소값
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("생성자 실행");
	}
	
	// 메모리에 저장되어 있는 객체(주소값) 리턴
	public static Singleton getInstance() {
		return singleton;
	}
}
