package ch07.sec02;

public class Phone {
	// 필드 선언
	public String model;
	public String color;
	
	Phone() {
		System.out.println("Phone 클래스 생성자");
	}
	
	// 메소드 선언
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기: " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방: " + message);
	}
	
	public void hangUp() {
		System.out.println("전화 끊기");
	}
}
