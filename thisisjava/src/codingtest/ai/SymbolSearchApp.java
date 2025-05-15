package codingtest.ai;

import java.util.*;
import java.util.stream.Collectors;

public class SymbolSearchApp {
    public static void main(String[] args) {
        List<String> encodedStrings = List.of("ZASSETE", "S4Z537B", "7_ASZEYB");
        List<String> words = List.of("2455373", "425", "373", "378");

        DigitSymbolMapper mapper = new DigitSymbolMapper();
        SymbolSearchService service = new SymbolSearchService(mapper);

        List<Integer> result = service.countMatches(encodedStrings, words);
        System.out.println(result);  // [3, 2, 3, 2]
    }
}

class DigitSymbolMapper {
    private final Map<Character, List<String>> digitToSymbols = new HashMap<>();
    private final Map<String, Set<Character>> symbolToDigits = new HashMap<>();

    public DigitSymbolMapper() {
        digitToSymbols.put('0', List.of("O", "()", "0"));
        digitToSymbols.put('1', List.of("I", "1"));
        digitToSymbols.put('2', List.of("Z", "S", "7", "2"));
        digitToSymbols.put('3', List.of("E", "B", "3"));
        digitToSymbols.put('4', List.of("A", "4"));
        digitToSymbols.put('5', List.of("S", "Z", "5"));
        digitToSymbols.put('6', List.of("b", "G", "6"));
        digitToSymbols.put('7', List.of("T", "Y", "7"));
        digitToSymbols.put('8', List.of("B", "E3", "8"));
        digitToSymbols.put('9', List.of("g", "q", "9"));

        for (Map.Entry<Character, List<String>> entry : digitToSymbols.entrySet()) {
            for (String symbol : entry.getValue()) {
                symbolToDigits.computeIfAbsent(symbol, k -> new HashSet<>()).add(entry.getKey());
            }
        }
    }

    public List<String> getSymbols(char digit) {
        return digitToSymbols.getOrDefault(digit, List.of(String.valueOf(digit)));
    }

    public Set<Character> getDigitsForSymbol(String symbol) {
        return symbolToDigits.getOrDefault(symbol, Set.of());
    }
}

class PatternGenerator {
    private final DigitSymbolMapper mapper;

    public PatternGenerator(DigitSymbolMapper mapper) {
        this.mapper = mapper;
    }

    public Set<String> generate(String digits) {
        Set<String> result = new HashSet<>();
        backtrack(digits, 0, new StringBuilder(), new HashSet<>(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, Set<String> usedSymbols, Set<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        for (String symbol : mapper.getSymbols(digit)) {
            if (usedSymbols.contains(symbol)) continue;
            if (mapper.getDigitsForSymbol(symbol).size() > 1) continue; 

            current.append(symbol);
            usedSymbols.add(symbol);

            backtrack(digits, index + 1, current, usedSymbols, result);

            current.setLength(current.length() - symbol.length());
            usedSymbols.remove(symbol);
        }
    }
}

class SymbolMatcher {
    public boolean matchesAny(String encoded, Set<String> patterns) {
        return patterns.stream().anyMatch(encoded::contains);
    }
}

class SymbolSearchService {
    private final PatternGenerator generator;
    private final SymbolMatcher matcher;

    public SymbolSearchService(DigitSymbolMapper mapper) {
        this.generator = new PatternGenerator(mapper);
        this.matcher = new SymbolMatcher();
    }

    public List<Integer> countMatches(List<String> encodedStrings, List<String> words) {
        return words.stream()
                .map(word -> {
                    Set<String> patterns = generator.generate(word);
                    return (int) encodedStrings.stream()
                            .filter(e -> matcher.matchesAny(e, patterns))
                            .count();
                })
                .collect(Collectors.toList());
    }
}

