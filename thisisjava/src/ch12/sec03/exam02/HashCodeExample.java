package ch12.sec03.exam02;

import java.util.HashSet;

public class HashCodeExample {

	public static void main(String[] args) {
		HashSet<Student> hashset = new HashSet<Student>();
		
		Student s1 = new Student(1, "홍길동");
		hashset.add(s1);
		System.out.println("저장된 객체 수: " + hashset.size());
		
		Student s2 = new Student(1, "홍길동");
		hashset.add(s2);
		System.out.println("저장된 객체 수: " + hashset.size());
		
		Student s3 = new Student(2, "홍길동");
		hashset.add(s3);
		System.out.println("저장된 객체 수: " + hashset.size());
		
		if (s1.hashCode() == s2.hashCode()) {
			if (s1.equals(s2)) {
				System.out.println("동등 객체입니다.");
			} else {
				System.out.println("데이터가 다르므로 동등 객체가 아닙니다.");
			}
		} else {
			System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
		}
	}

}
