package codingtest.numsearch;

import java.util.Set;

public class SymbolMatcher {
	public boolean matchesAny(String numstr, Set<String> patterns) {
		return patterns.stream().anyMatch(numstr::contains);
	}
}
