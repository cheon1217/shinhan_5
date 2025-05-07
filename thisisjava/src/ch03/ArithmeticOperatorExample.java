package ch03;

public class ArithmeticOperatorExample {

	public static void main(String[] args) {
		byte v1 = 10;
		byte v2 = 4;
		int v3 = 5;
		long v4 = 10L;
		
		int result1 = v1 + v2;
		System.out.println("result1: " + result1);
		
		long result2 = v1 + v2 - v4;
		System.out.println("result2: " + result2);
		
		double result3 = (double)v1 / v2;
		System.out.println("result3: " + result3);
		
		int result4 = v1 % v2;
		System.out.println("result4: " + result4);
		
		int num1 = 3;
		int num2 = 2;
		double answer = (double)num1 / (double)num2;
		double result = answer * 1000;
		System.out.println((int)result);
		
	}

}
