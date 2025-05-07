package ch11;

public class ExceptionEx {

	public static void main(String[] args) throws Exception {
		System.out.println("시작");
		int a = 3;
		int b = 0;
		int[] arr = {1, 2, 3};
		String str = null;
		try {
			// 예외가 발생 가능성 있는 코드
//			System.out.println(b);
			int c = a / b; // ArithmeticException
			System.out.println(arr[3]);  // ArrayIndexOutOfBoundsException
			System.out.println(str.charAt(0));  // NullPointerException
//		} catch (ArithmeticException e) {
//			System.out.println("예외 발생");
//			System.out.println(e.getMessage());  // 예외 정보 얻는 방법 1
//			System.out.println(e.toString());       // 예외 정보 얻는 방법 2
//			e.printStackTrace();                          // 예외 정보 얻는 방법 3
//		} catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
		} catch (Exception e) { // 부모가 위로 올라가게 되면 에러남 (작은거 -> 큰거 순)
			System.out.println("그외 예외처리");
			System.out.println(e);
		} finally { // 마지막으로 실행 (항상 무조건 실행)
			// 예외 발생 여부와 상관없이 실행
			System.out.println("무조건 실행");
		}
		System.out.println("끝");
		
//		try {
			test();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	// 어쩔 수 없이 예외처리 해야하는 상황
	public static void test() throws Exception {
//		try {
			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	
	void exception() {
		try {
			// 예외가 발생 가능성 있는 코드
		} catch (Exception e) {
			// 예외가 발생하면 실행되는 코드
		} finally {
			// 항상 무조건 실행되는 코드
		}
	}

}
