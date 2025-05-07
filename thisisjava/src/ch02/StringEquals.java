package ch02;

public class StringEquals {

	public static void main(String[] args) {
		String name1 = "박재천";
		String name2 = "박재천";
		
		System.out.println(name1 == name2);
		
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		System.out.println(name3 == name4);
		System.out.println(name3.equals(name4));
		
		String name = null;
		System.out.println("admin".equals(name));
//		name.equals("");
		
	}

}
