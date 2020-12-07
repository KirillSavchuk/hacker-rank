package medium;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem source: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
@Singleton
public class SherlockAndValidString {

	public String solve(String str) {
		return isValidString(str) ? "YES" : "NO";
	}

	private boolean isValidString(String str) {
		final Map<Character, Integer> charOccurrences = getCharOccurrencesMap(str);

		final Integer[] occurrences = charOccurrences.values().stream().sorted().toArray(Integer[]::new);
		final int occurrencesCount = occurrences.length;
		if (occurrencesCount <= 1) {
			return true;
		}

		if (occurrences[0] == 1) {
			int commonValue = occurrences[1];
			for (int i = 2; i < occurrencesCount; i++) {
				if (commonValue != occurrences[i]) {
					return false;
				}
			}
			return true;
		} else {
			final int minOccurrence = occurrences[0];
			final int maxOccurrence = occurrences[occurrencesCount - 1];
			if (maxOccurrence - minOccurrence >= 2) {
				return false;
			}

			for (int i = 1; i < occurrencesCount - 1; i++) {
				if (minOccurrence != occurrences[i]) {
					return false;
				}
			}
			return true;
		}
	}

	private Map<Character, Integer> getCharOccurrencesMap(String str) {
		Map<Character, Integer> charOccurrences = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (charOccurrences.containsKey(ch)) {
				charOccurrences.put(ch, charOccurrences.get(ch) + 1);
			} else {
				charOccurrences.put(ch, 1);
			}
		}
		return charOccurrences;
	}

}