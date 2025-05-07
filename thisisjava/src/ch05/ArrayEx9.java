package ch05;

import java.util.Scanner;

public class ArrayEx9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int student = 0;
		int[] scores = {};
		
		while (true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택> ");
			
			int num = scanner.nextInt();
			
			if (num == 1) {
				System.out.print("학생수> ");
				student = scanner.nextInt();
				scores = new int[student];
			} else if (num == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.print("[" + i + "] 점수입력> ");
					scores[i] = scanner.nextInt();
				}
			} else if (num == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("[" + i + "] 점수> " + scores[i]);
				}
			} else if (num == 4) {
				int bestScore = 0;
				int sum = 0;
				
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if (bestScore < scores[i]) {
						bestScore = scores[i];
					}
				}
				
				double avg = (double)sum / student;
				System.out.println("최고점수: " + bestScore);
				System.out.println("평균점수: " + avg);
			} else if (num == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
