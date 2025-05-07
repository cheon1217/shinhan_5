package ch07.sec03.exam02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		Phone ph = new Phone("아이폰", "스타라이트");
		SmartPhone myPhone = new  SmartPhone("갤럭시", "은색");
		
		System.out.println("모델: " + ph.model);
		System.out.println("색상: " + ph.color);
		
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
	}

}
