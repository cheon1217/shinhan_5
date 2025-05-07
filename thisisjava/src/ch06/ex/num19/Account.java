package ch06.ex.num19;

public class Account {
	static final int MINI_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	private int balance = 0;

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		if (balance >= MINI_BALANCE && balance <= MAX_BALANCE) {			
			this.balance = balance;
		}
	}
	
}
