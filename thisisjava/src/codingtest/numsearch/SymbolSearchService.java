package codingtest.numsearch;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SymbolSearchService {

    private final PatternGenerator generator;
    private final SymbolMatcher matcher;

    public SymbolSearchService(DigitSymbolMapper mapper) {
        this.generator = new PatternGenerator(mapper);
        this.matcher = new SymbolMatcher();
    }

    public List<Integer> countMatches(List<String> encodedStrings, List<String> words) {
        return words.stream()
                .map(word -> generatePatternAndCount(encodedStrings, word))
                .collect(Collectors.toList());
    }

    private int generatePatternAndCount(List<String> encodedStrings, String word) {
        Set<String> patterns = generator.generate(word);
        return (int) encodedStrings.stream()
                .filter(numstr -> matcher.matchesAny(numstr, patterns))
                .count();
    }
}
