package codingtest;

import java.util.Arrays;

public class Vip {
	
	public int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] answer = { 0, 0 };
		
		for (int i = 0; i < periods.length; i++) {
			int totalPayment = 0;
			int currentPeriod = periods[i];
			
			totalPayment = getTotal(payments[i]);
			
			boolean currentVip = isVip(currentPeriod, totalPayment);

			totalPayment += estimates[i] - payments[i][0];
			
			boolean nextVip = isVip(currentPeriod + 1, totalPayment);
			
			if (!currentVip && nextVip) {
				answer[0]++;
			}
			
			if (currentVip && !nextVip) {
				answer[1]++;
			}
			
		}
		
		return answer;
	}
	
	public int getTotal(int[] payments) {
		int sum = 0;
		for (int i = 0; i < payments.length; i++) {
			sum += payments[i];
		}
		return sum;
	}
	
	private boolean isVip(int period, int total) {
		if (period < 24) return false;
		else if (period < 60) return total >= 900000;
		else return total >= 600000;
	}

	public static void main(String[] args) {
		Vip solution = new Vip();
		int[] periods1 = {24, 59, 59, 60};
        int[][] payments1 = {
        		{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}, 
        		{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }, 
        		{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }, 
        		{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }
        	};
        int[] estimates1 = {350000, 50000, 40000, 50000};

        int[] result = solution.solution(periods1, payments1, estimates1);
		System.out.println(Arrays.toString(result));
		
		int[] periods2 = {8, 23, 24};
		int[][] payments2 = {
				{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, 
				{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, 
				{350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}
		};
		int[] estimates2 = {100000, 100000, 100000};
		
		int[] result2 = solution.solution(periods2, payments2, estimates2);
		System.out.println(Arrays.toString(result2));
	}

}
