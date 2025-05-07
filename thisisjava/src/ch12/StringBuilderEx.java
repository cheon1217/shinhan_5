package ch12;

public class StringBuilderEx {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
//		String str = "";
//		for (int i = 0; i < 1000000; i++) {
//			str += i;
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000000; i++) {
			sb.append(i);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
