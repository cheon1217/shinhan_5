package ch08.sec01;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc = new Television(); // 자동형변환
		rc.turnOn(); // 재정의된 메소드 실행
	}

}
