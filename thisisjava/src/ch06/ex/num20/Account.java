package ch06.ex.num20;

public class Account {
	private String accNum;
	private String accOwn;
	private int balance;
	
	public Account(String accNum, String accOwn, int balance) {
		this.accNum = accNum;
		this.accOwn = accOwn;
		this.balance = balance;
	}
	
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getAccOwn() {
		return accOwn;
	}
	public void setAccOwn(String accOwn) {
		this.accOwn = accOwn;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
