package ch07.sec02;

public class SmartPhoneExample {

	public static void main(String[] args) {
		// SmartPhone 객체 생성
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// Phone으로부터 상속 받은 필드 읽기
		System.out.println("모델: " + myPhone.model);
		System.out.println("색상: " + myPhone.color);
		
		// SmartPhone의 필드 읽기
		System.out.println("와이파이 상태: " + myPhone.wifi);
		
		// Phone으로부터 상속받은 메소드 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동입니다.");
		myPhone.sendVoice("아 반갑습니다~");
		myPhone.hangUp();
		
		// SmartPhone의 메소드 호출
		myPhone.setWifi(true);
		myPhone.internet();
		
		// 자동형변환
		Phone ph = new SmartPhone("아이폰", "검정");
//		ph.internet(); // 사용불가
		
		// 강제형변환 (원래 자식타입이 부모타입으로 형 변환된 경우에만 가능)
		SmartPhone smp = (SmartPhone)ph;
		smp.internet(); // 사용가능
		
		// runtime error 발생 - 불가능함
//		Phone myPhone4 = new Phone();
//		SmartPhone myPhone5 = (SmartPhone)myPhone4;
//		myPhone5.internet();
	}

}
