package ch14.sec07.exam01;

public class SafeStopExample {

	public static void main(String[] args) {
		PrintThread pt = new PrintThread();
		pt.start();
		
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		
		pt.setStop(true);
	}

}
