package medium;

import com.google.inject.Singleton;

/**
 * Problem source: https://www.hackerrank.com/challenges/richie-rich/problem
 */
@Singleton
public class HighestValuePalindrome {

	final static char MAX_VALUE = '9';

	public String solve(String str, int length, int maxModifications) {
		char[] chars = str.toCharArray();
		int requiredModifications = getPalindromeDiffCount(chars, length);
		if (requiredModifications > maxModifications) {
			return "-1";
		} else {
			int extraModifications = maxModifications - requiredModifications;
			for (int i = 0; i < Math.ceil((double) length / 2); i++) {
				final int mirrorIndex = length - i - 1;
				if (chars[i] != chars[mirrorIndex]) {
					requiredModifications--;
					if (extraModifications >= 1) {
						if (chars[i] != MAX_VALUE && chars[mirrorIndex] != MAX_VALUE) {
							extraModifications--;
						}
						chars[i] = MAX_VALUE;
						chars[mirrorIndex] = MAX_VALUE;
					} else {
						if (chars[i] > chars[mirrorIndex]) {
							chars[mirrorIndex] = chars[i];
						} else {
							chars[i] = chars[mirrorIndex];
						}
					}
				} else if (extraModifications >= 2) {
					if (chars[i] != MAX_VALUE) {
						chars[i] = MAX_VALUE;
						chars[mirrorIndex] = MAX_VALUE;
						extraModifications -= 2;
					}
				} else if (i == mirrorIndex) {
					if (extraModifications >= 1) {
						chars[i] = MAX_VALUE;
						extraModifications--;
					}
				}
			}
		}
		return String.valueOf(chars);
	}

	protected char[] setMaxMiddleChar(char[] chars, int length) {
		if (length % 2 == 1) {
			chars[length / 2] = MAX_VALUE;
		}
		return chars;
	}

	protected int getPalindromeDiffCount(char[] chars, int length) {
		int palindromeDiffCount = 0;
		for (int i = 0; i < Math.floorDiv(length, 2); i++) {
			if (chars[i] != chars[length - i - 1]) {
				palindromeDiffCount++;
			}
		}
		return palindromeDiffCount;
	}

}