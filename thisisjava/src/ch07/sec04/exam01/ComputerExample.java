package ch07.sec04.exam01;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		
		Calculator cal = new Calculator();
		System.out.println("원 면적: " + cal.areaCircle(r));
		System.out.println();
		
		Computer c = new Computer();
		System.out.println("원 면적: " + c.areaCircle(r));
		c.game();
		
		Calculator cal2 = c; // 자동형변환
		cal2.areaCircle(r); // 부모타입의 메소드가 실행 -> 실제로 자식 메소드가 실행됨 
//		cal2.game(); // 사용 불가
		
		// 다형성 : 타입이 달라지는 성질 -> 실행코드는 하나인데 결과가 달라지는 것
		
		Computer com = (Computer) cal2;
		System.out.println(com.toString());
		
		Object o1 = new String("안녕"); // 자동형변환
		System.out.println(o1.toString()); // 자식이 재정의한 메소드
//		System.out.println(o1.replace("", ""));
		
		String s1 = (String) o1; // 강제형변환
		System.out.println(s1.replace("", ""));
		
		Object o2 = new Object();
//		String s2 = (String) o2;
	}

}
