package ch06.sec08.exam03;

public class Car {
	static String country = "대한민국";
	int gas;
	
//	final String color = "black";
	
//	Car(String color) {
//		this.color = color;
//	}

	void changeColor() {
//		color = "black";
	}
	
	// 리턴값이 없는 메서드로 매개값을 받아서 gas 필드값으로 변경
	void setGas(int gas) {
		this.gas = gas;
	}
	
	int getGas() {
		return this.gas;
	}
	
	// 리턴값을 boolean인 메소드로 gas 필드값이 0이면 false를, 0이 아니면 true를 리턴
	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}
	
	// 리턴값이 없는 메소드로 gas 필드값이 0이면 return 문으로 메소드를 종료
	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("달립니다.(gas 잔량: " + gas + ")");
				gas -= 1;
			} else {
				System.out.println("멈춥니다.(gas 잔량: " + gas + ")");
				return;
			}
		}
	}
}
