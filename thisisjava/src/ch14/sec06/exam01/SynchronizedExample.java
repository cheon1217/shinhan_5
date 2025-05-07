package ch14.sec06.exam01;

public class SynchronizedExample {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User1Thread user1 = new User1Thread();
		user1.setCalculator(cal);
		user1.start();
		
		User2Thread user2 = new User2Thread();
		user2.setCalculator(cal);
		user2.start();
	}

}
