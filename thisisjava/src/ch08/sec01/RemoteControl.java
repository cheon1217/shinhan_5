package ch08.sec01;

public interface RemoteControl {
	int VOLUME = 0; // static final 상수
	void turnOn(); // public abstract
	
	// 일반 메서드
	default int add(int x, int y) {
		return x + y;
	}
}
