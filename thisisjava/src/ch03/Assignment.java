package ch03;

public class Assignment {

	public static void main(String[] args) {
		// 3번
		int pencils = 534;
		int students = 30;
		
		// 학생 한 명이 가지는 연필 수
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		// 남은 연필 수
		int penclisLeft = pencils % students;
		System.out.println(penclisLeft);
		
		// 4번
		int value = 356;
		System.out.println((value / 100) * 100);
		
		// 문자열 바꾸기
		String answer = "jaron";
		String result = "";
        for (int i = answer.length() -1; i >= 0; i--) {
        	result += answer.charAt(i);
        }
        System.out.println(result);
        
        // 분모 분자 더하기
        
	}

}
