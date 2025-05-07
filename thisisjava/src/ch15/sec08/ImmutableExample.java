package ch15.sec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {

	public static void main(String[] args) {
		// List 불변 컬렉션 생성
		List<String> immutableList1 = List.of("A", "B", "C");
//		immutableList1.add("D"); // x
		System.out.println(immutableList1);
		
		// Set 불변 컬렉션 생성
		Set<String> immutableSet1 = Set.of("A", "B", "C");
//		immutableSet1.remove("A"); // x
		System.out.println(immutableSet1);
		
		// Map 불변 컬렉션 생성
		Map<Integer, String> immutableMap1 = Map.of(1, "A", 2, "B", 3, "C");
//		immutableMap1.put(4, "D"); // x
		System.out.println(immutableMap1);
		
		System.out.println("------------------------------------");
		
		// List 컬렉션을 불변 컬렉션으로 복사
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		List<String> immutableList2 = List.copyOf(list);
		System.out.println(immutableList2);
		
		// Set 컬렉션으로 불변 컬렉션으로 복사
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		Set<String> immutableSet2 = Set.copyOf(set);
		System.out.println(immutableSet2);
		
		// Set 컬렉션으로 불변 컬렉션으로 복사
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Map<Integer, String> immutableMap2 = Map.copyOf(map);
		System.out.println(immutableMap2);
		
		System.out.println("------------------------------------");
		
		String[] arr = { "A", "B", "C" };
		List<String> immutableList3 = Arrays.asList(arr);
		System.out.println(immutableList3);
	}

}
