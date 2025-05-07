package ch04;

import java.util.Scanner;

public class AddSolutions2 {

	public static void main(String[] args) {
		// 숫자 맞추기 
		// 1 ~ 100까지 랜덤수 정해서 사용자가 맞추는 게임
		// 틀리면: 입력하신 숫자보다 큰(작은) 숫자를 입력하세요
		// 맞으면: 정답입니다. 시도횟수: n회
		
		Scanner scanner = new Scanner(System.in);
		
		int randNum = (int) (Math.random() * 100 + 1);
//		System.out.println(randNum);
		int count = 0;
		
		while (true) {
			
			System.out.print("1 ~ 100 사이의 숫자를 입력하세요: ");
			
			String strNum = scanner.nextLine();
			int inputNum = Integer.parseInt(strNum);
			
			if (randNum > inputNum) {
				System.out.println("입력하신 숫자보다 더 큰 숫자를 입력하세요.");
				count++;
			} else if (randNum < inputNum) {
				System.out.println("입력하신 숫자보다 더 작은 숫자를 입력하세요.");
				count++;
			} else if (randNum == inputNum) {
				count++;
				System.out.println("정답입니다. " + count + "번만에 성공!");
				break;
			}
			
		}
		
	}

}
