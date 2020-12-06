package easy;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

/**
 * Problem source: https://www.hackerrank.com/challenges/two-characters/problem
 */
@Singleton
public class TwoCharacters {

	public int solve(String str) {
		NotAlternatingSequenceSolver solver = new NotAlternatingSequenceSolver(str);
		return solver.getNotAlternatingSequenceMaxLength();
	}

	static class NotAlternatingSequenceSolver {

		private String str;
		private final List<Character> distinctChars;
		private final List<Character> alternatingChars;

		public NotAlternatingSequenceSolver(String str) {
			this.str = str;
			this.distinctChars = new ArrayList<>();
			this.alternatingChars = new ArrayList<>();
		}

		public int getNotAlternatingSequenceMaxLength() {
			this.findDistinctChars();
			this.removeAlternatingChars();

			int maxLength = 0;
			for (int i = 0; i < distinctChars.size() - 1; i++) {
				for (int j = i + 1; j < distinctChars.size(); j++) {
					char currChar = distinctChars.get(i);
					char nextChar = distinctChars.get(j);
					String replacedString = str.replaceAll(format("[^%s%s]", currChar, nextChar), "");
					if (hasAlternatingChars(replacedString)) {
						maxLength = Math.max(maxLength, replacedString.length());
					}
				}
			}
			return maxLength;
		}

		private void removeAlternatingChars() {
			if (alternatingChars.isEmpty()) {
				return;
			}

			String alternatingCharString = alternatingChars.stream().map(String::valueOf).collect(joining());
			this.str = this.str.replaceAll(format("[%s]", alternatingCharString), "");
		}

		private void findDistinctChars() {
			char currChar;
			char prevChar = '_';
			for (int i = 0; i < str.length(); i++) {
				currChar = str.charAt(i);

				if (alternatingChars.contains(currChar)) continue;

				if (distinctChars.contains(currChar)) {
					if (currChar == prevChar) {
						alternatingChars.add(currChar);
						distinctChars.remove(currChar);
					}
				} else {
					distinctChars.add(currChar);
				}
			}
		}

		private boolean hasAlternatingChars(String str) {
			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) == str.charAt(i + 1)) return false;
			}
			return true;
		}

	}

}