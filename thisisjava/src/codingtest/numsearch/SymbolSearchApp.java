package codingtest.numsearch;

import java.util.List;

public class SymbolSearchApp {

    public static void main(String[] args) {
        List<String> encodedStrings1 = List.of("ZASSETE", "S4Z537B", "7_ASZEYB");
        List<String> encodedStrings2 = List.of("ZAZZ373");
        List<String> words1 = List.of("2455373", "425", "373", "378");
        List<String> words2 = List.of("2422373", "5455373", "2455373");

        DigitSymbolMapper mapper = new DigitSymbolMapper();
        SymbolSearchService service = new SymbolSearchService(mapper);

        List<Integer> result1 = service.countMatches(encodedStrings1, words1);
        List<Integer> result2 = service.countMatches(encodedStrings2, words2);
        System.out.println(result1);
        System.out.println(result2);
    }
}
