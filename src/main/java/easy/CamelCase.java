package easy;

import com.google.inject.Singleton;

/**
 * Problem source: https://www.hackerrank.com/challenges/camelcase/problem
 */
@Singleton
public class CamelCase {

	public int solve(String camelCaseStr) {
		if(camelCaseStr.isEmpty()) {
			return 0;
		}

		int wordCount = 1;
		for (int i = 0; i < camelCaseStr.length(); i++) {
			if (Character.isUpperCase(camelCaseStr.charAt(i))) {
				wordCount++;
			}
		}
		return wordCount;
	}

}