package codingtest.numsearch;

import java.util.List;
import java.util.Map;

public class DigitSymbolMapper {

    private final Map<Character, List<String>> symbolMap;

    public DigitSymbolMapper() {
        symbolMap = Map.of(
                '0', List.of("O", "()", "0"),
                '1', List.of("I", "1"),
                '2', List.of("Z", "S", "7", "2"),
                '3', List.of("E", "B", "3"),
                '4', List.of("A", "4"),
                '5', List.of("S", "Z", "5"),
                '6', List.of("b", "G", "6"),
                '7', List.of("T", "Y", "7"),
                '8', List.of("B", "E3", "8"),
                '9', List.of("g", "q", "9")
        );
    }

    public List<String> getSymbols(char digit) {
        return symbolMap.getOrDefault(digit, List.of(String.valueOf(digit)));
    }
}
