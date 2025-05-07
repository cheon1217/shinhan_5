package ch04;

public class IfNestedExample {

	public static void main(String[] args) {
		int score = (int)(Math.random() * 20) + 81;
		System.out.println("점수: " + score);
		
		String grade;
		
		if (score >= 90) {
			if (score >= 95) {
				grade = "A+";
			} else {
				grade = "A";
			}
		}  else {
			if (score >= 85) {
				grade = "B+";
			} else {
				grade = "B";
			}
		}
		System.out.println("학점: " + grade);
		
		int math = 70;
		int eng = 30;
		
		// 잘못됨
		if (math >= 60) {
			if (eng >= 60) {
				System.out.println("합격");
			}
		} else {
			System.out.println("불합격");
		}
		
		
		if (math >= 60 && eng >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		
		
		
	}

}
