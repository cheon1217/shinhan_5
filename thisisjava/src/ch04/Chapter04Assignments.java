package ch04;

import java.util.Scanner;

public class Chapter04Assignments {

	public static void main(String[] args) {
		// 3.
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
				System.out.print(i + " ");
			}
		}
		System.out.println(sum);
		System.out.println();
		
		// 4.
		
		while (true) {
			
			int dice1 = (int)(Math.random() * 6 + 1);
			int dice2 = (int)(Math.random() * 6 + 1);
			
			if (dice1 + dice2 == 5) {
				System.out.println("(" + dice1 + ", " + dice2 + ")");
				break;
			}
		}
		
//		System.out.println(dice1);
		
		// 5.
		for (int x = 1; x <=  10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4*x) + (6*y) == 60) {
					System.out.println("(" + x + ", " + y + ")");
				}
			}
		}
		
		// 6.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 7.
		Scanner scanner = new Scanner(System.in);
		
		int money = 0;
		
		while (true) {
			System.out.println("-----------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			
			String strNum = scanner.nextLine();
			
			if (strNum.equals("1")) {
				System.out.print("예금할 금액> ");
				int depositMoney = Integer.parseInt(scanner.nextLine());
				money += depositMoney;
			}
			
			if (strNum.equals("2")) {
				System.out.print("출금할 금액> ");
				int withdrawMoney = Integer.parseInt(scanner.nextLine());
				money -= withdrawMoney;
			}
			
			if (strNum.equals("3")) {
				System.out.print("잔액> " + money);
				System.out.println();
			}
			
			if (strNum.equals("4")) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		
		
	}

}
