package ch06.sec08.exam03;

public class CarExample {
	
	private final int age = 10;

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(5);
		System.out.println(myCar.getGas());
		
		if (myCar.isLeftGas()) {
			System.out.println("출발합니다.");
			
			myCar.run();
		}
		
		System.out.println("gas를 주입하세요.");
		
		// 객체 생성하지 않아도 메모리에 로드
		System.out.println(Car.country);
		myCar.country = "미국";
		System.out.println(myCar.country);
		
		Car myCar2 = new Car();
		System.out.println(myCar2.country);
		System.out.println(Car.country);
	}

}
