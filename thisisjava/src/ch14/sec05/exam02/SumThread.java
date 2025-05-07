package ch14.sec05.exam02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumThread extends Thread {
	private long sum;
	
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}
}
