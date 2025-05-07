package codingtest.numsearch;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PatternGenerator {
    private final DigitSymbolMapper mapper;

    public PatternGenerator(DigitSymbolMapper mapper) {
        this.mapper = mapper;
    }

    public Set<String> generate(String digits) {
        return generateRecursive(digits, 0, "");
    }

    private Set<String> generateRecursive(String digits, int idx, String current) {
        if (idx == digits.length()) return Set.of(current);

        char digit = digits.charAt(idx);
        List<String> symbols = mapper.getSymbols(digit);

        return symbols.stream()
                .flatMap(symbol -> generateRecursive(digits, idx + 1, current + symbol).stream())
                .collect(Collectors.toSet());
    }
}
