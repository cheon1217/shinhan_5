package ch06.ex.num14_15;

public class Member {
	
	String name;
	String id;
	String password;
	int age;
	
	Member() {
		
	}
	
	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	boolean login(String id, String password) {
		if (id.equals("hong") && password.equals("12345")) {
			return true;
		} else {			
			return false;
		}
	}
	
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}

	public static void main(String[] args) {
		Member user1 = new Member("홍길동", "hong");
		
		Member user = new Member();
		boolean result = user.login("hong", "12345");
		if (result) {
			System.out.println("로그인 되었습니다.");
			user.logout("hong");
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}

}
