package ch04;

public class PrintFrom1To10Example {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while (i <= 100) {
			System.out.print(i + " ");
			sum += i;
			i++;
		}
		System.out.println();
		System.out.println(sum);
	}

}
