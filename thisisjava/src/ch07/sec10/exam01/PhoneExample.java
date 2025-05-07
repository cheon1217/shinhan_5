package ch07.sec10.exam01;

public class PhoneExample {

	public static void main(String[] args) {
//		Phone ph = new Phone(); // 불가능
		
		SmartPhone sp = new SmartPhone("홍길동");
		
		sp.turnOn();               // Phone 메소드
		sp.internetSearch();
		sp.turnOff();			     // Phone 메소드
		
		Phone ph = new SmartPhone("홍길동");
		ph.turnOn();
//		ph.internetSearch(); // 에러
		ph.turnOff();
	}

}
