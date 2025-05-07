package ch07.sec10.exam01;

public class SmartPhone extends Phone {
	
	
	@Override
	void receive() {
		System.out.println("메소드 재정의");
	}

	SmartPhone(String owner) {
		super(owner);
	}
	
	void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
	
}
