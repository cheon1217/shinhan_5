package codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeAccounts {
	
	public static boolean isValid(String account) {
		if (!account.matches("[0-9\\-]+")) return false;
		if (account.startsWith("-") || account.endsWith("-")) return false;
		if (account.contains("--")) return false;
		
		String digitsOnly = account.replaceAll("[^0-9]", "");
		if (digitsOnly.length() < 11 || digitsOnly.length() > 14) return false;
		
		long hyphenCount = account.chars().filter(ch -> ch == '-').count();
		if (hyphenCount > 3) return false;
		
		return true;
	}
	
	public static String makeBankKey(String account) {
		int digitCount = 0;
		List<Integer> hyphenPositions = new ArrayList<>();
		
		for (int i = 0; i < account.length(); i++) {
			char c = account.charAt(i);
			if (Character.isDigit(c)) {
				digitCount++;
			} else if (c == '-') {
				hyphenPositions.add(i);
			}
		}
		
		return digitCount + "|" + hyphenPositions.toString();
	}
	
	public static List<Integer> solution(String[] nums) {
		Map<String, Integer> bankMap = new HashMap<>();
		
		for (String acc : nums) {
			if (isValid(acc)) {
				String key = makeBankKey(acc);
				bankMap.put(key, bankMap.getOrDefault(key, 0) + 1);
			}
		}
		
		List<Integer> result = new ArrayList<>(bankMap.values());
		result.sort(Collections.reverseOrder());
		return result;
	}

	public static void main(String[] args) {
		String[] nums1 = {
            "4514--234495-1", "305-44-291501", "1-2-34-495-8623", "492134545151",
            "623-421523-67-341", "-5439-59639921", "6235-7X3-47-7456",
            "98-76-543-210", "512-73-634901", "000-999999-22-555", "064-82-792561"
        };
		
		String[] nums2 = {
			"1-2-3-456789012","582845-385823","48572-39485-89012","4-5-2-593328484",
			"4958-392945123-","49582039415423","7-3-7-000000000","485723-693812",
			"39482746582734","1-1-1-111111111","A4944-5095-4951","4851293412223"	
		};
		
		String[] nums3 = {
			"592356=5345","49-694-4495-64","5923565345%"	
		};
		
		List<Integer> result1 = solution(nums1);
        System.out.println(result1); 
        
        List<Integer> result2 = solution(nums2);
        System.out.println(result2); 
        
        List<Integer> result3 = solution(nums3);
        System.out.println(result3); 
	}

}
