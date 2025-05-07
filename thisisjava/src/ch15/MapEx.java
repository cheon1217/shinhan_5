package ch15;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {
		String[] names = {"홍길동", "김길동", "최길동", "홍영수"};
		
		Map<String, Integer> map = new HashMap<>();
		for (String n : names) {
			if (map.get(String.valueOf(n.charAt(0))) == null) {
				map.put(String.valueOf(n.charAt(0)), 1);
			} else {
				map.put(String.valueOf(n.charAt(0)), map.get(String.valueOf(n.charAt(0))) + 1);
			}
//			map.put(String.valueOf(n.charAt(0)), map.getOrDefault(String.valueOf(n.charAt(0)), 0)+1);
		}
		System.out.println(map);
		
		}

}
