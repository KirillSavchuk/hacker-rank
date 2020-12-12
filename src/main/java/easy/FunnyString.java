package easy;

import com.google.inject.Singleton;

/**
 * Problem source: https://www.hackerrank.com/challenges/funny-string/problem
 */
@Singleton
public class FunnyString {

	public String solve(String str) {
		return isFunnyString(str) ? "Funny" : "Not Funny";
	}

	private boolean isFunnyString(String str) {
		final int length = str.length() - 1;
		for (int i = 0; i < length / 2; i++) {
			if (Math.abs(str.charAt(i + 1) - str.charAt(i)) != Math.abs(str.charAt(length - i) - str.charAt(length - i - 1))) {
				return false;
			}
		}
		return true;
	}

}