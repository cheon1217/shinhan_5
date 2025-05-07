package ch17.sec01.exam01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import lombok.ToString;

public class StreamExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("신용권");
		set.add("김자바");
		
		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
		
		List<Member> list = new ArrayList<>();
		list.add(new Member());
		list.add(new Member());
		list.add(new Member());
		list.stream().forEach(e -> System.out.println(e));
	}

}

@ToString
class Member {
	private int no;
	private String name;
}
