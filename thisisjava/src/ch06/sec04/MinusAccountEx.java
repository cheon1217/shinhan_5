package ch06.sec04;

public class MinusAccountEx {
	
	public static int solution (int m, int[] ledger) {
		int account = 0;

		for (int i = 0; i < ledger.length; i++) {
			if (account  + ledger[i] >= -5000) {
				account += ledger[i];
			}
		}

		return account;
	}
	

	public static void main(String[] args) {
		System.out.println(solution(5000, new int[] {10000, -13000, -4000, -2000, 6500, -20000}));
		System.out.println(solution(34151, new int[] {-34151, -40000, -50000}));
	}

}
