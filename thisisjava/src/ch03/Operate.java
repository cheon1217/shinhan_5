package ch03;

public class Operate {

	public static void main(String[] args) {
		// 증감연산
		// 증가 : ++ 1 증가
		// 감소 :  --  1 감소
		// 전위연산 : ++a (실행문이 실행되기 전)
		// 후위연산 : a++ (실행문이 실행된 후)
		int a = 10;
//		++a;
//		a++;
		System.out.println(a++);
		System.out.println(a);
		
		// 산술연산
		// + - * / % (나머지)
		// 정수와 정수의 연산의 결과값이 정수
		// 10 / 4 -> 2
		int b = a / 4;
		System.out.println(b);
		
		int score1 = 90;
		int score2 = 80;
		int score3 = 75;
		int total = score1 + score2 + score3;
		double avg = (double)total / 3;
		System.out.println(avg);
		
//		int c = b / 0; // 예외발생
		System.out.println("출력");
		
		// 비교연산 : 결과값이 true | false
		// ==, !=, >, <, >=, <=
		// ! : 반대
		
		// 논리연산
		// and (그리고) : 양쪽항 모두 true이면 true
		System.out.println(a == 10 && test());
		// or (또는) : 양쪽항 둘 중 하나 이상이 true 이면 true
		System.out.println(a == 10 || b < 10);
		
//		int[] arr = {1, 2, 3};
//		System.out.println(arr.length);
//		String name = "홍길동";
//		System.out.println(name.length());
		
		String name = null;
		
		if  (name != null && name.length() > 3) {
			System.out.println("4자리 이상입니다.");
		}
		
		// 대입연산
		a += 1; // 1 더하고 대입
		a = a + 1;
		System.out.println(a);
		
		// 삼항연산
		// 조건 ? 참이면 : 거짓이면
		int score = 80;
		String result = (score > 60) ? "합격" : "불합격";
		System.out.println(result);
		
		// 우선순위가 가장 낮은 연산 : 대입
		// 우선순위가 가장 높은 연산 : 괄호()
		
		
		
	}
	
	public static boolean test() {
		System.out.println("메서드 실행");
		return true;
	}

}
