package expert;

import com.google.inject.Singleton;

import java.util.Set;
import java.util.TreeSet;

/**
 * Problem source: https://www.hackerrank.com/challenges/find-strings/problem
 * <br/>
 * Tests passed: 7/8. Issue: Time limit exceeded.
 */
@Singleton
public class FindStrings {

	public String[] solve(String[] strings, int[] positions) {
		Set<String> suffixSet = initSuffixSet(strings);
		String[] res = new String[positions.length];
		for (int i = 0; i < positions.length; i++) {
			res[i] = getElement(suffixSet, positions[i]);
		}
		return res;
	}

	protected Set<String> initSuffixSet(String[] strings) {
		Set<String> suffixSet = new TreeSet<>();
		for (int s = 0; s < strings.length; s++) {
			String str = strings[s];
			for (int i = 0; i < str.length(); i++) {
				String nextString = str.substring(i);
				if (!suffixSet.add(nextString) || hasDuplicateChars(nextString)) break;
			}
		}
		return suffixSet;
	}

	private boolean hasDuplicateChars(String str) {
		final int strLength = str.length();
		if (strLength <= 1) {
			return false;
		}
		char ch = str.charAt(0);
		for (int i = 1; i < strLength; i++) {
			if (ch != str.charAt(i)) return false;
		}
		return true;
	}

	public String getElement(Set<String> suffixSet, int pos) {
		String prevString = "";
		for (String nextString : suffixSet) {
			int skipPos = 0;
			while (shouldBeSkipped(prevString, nextString, skipPos)) {
				skipPos++;
			}

			if (pos > nextString.length() - skipPos) {
				pos = pos - nextString.length() + skipPos;
				prevString = nextString;
				continue;
			}

			return nextString.substring(0, pos + skipPos);
		}
		return "INVALID";
	}

	private boolean shouldBeSkipped(String prevString, String nextString, int skipPos) {
		return skipPos < prevString.length() &&
			skipPos < nextString.length() &&
			prevString.charAt(skipPos) == nextString.charAt(skipPos);
	}

}