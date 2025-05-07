package ch04;

public class ForExample {

	public static void main(String[] args) {
		for (int a = 1; a <= 10; a++) {
			System.out.println("반복" + a);
		}
		System.out.println("바깥");
		
		int[] score = {90, 80, 70};
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]);
		}
//		System.out.println(score[2]);
		
		// 구구단
		// 2단
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
		}
		
		

	}

}
