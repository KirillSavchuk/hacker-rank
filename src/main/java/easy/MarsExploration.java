package easy;

import com.google.inject.Singleton;

/**
 * Problem source: https://www.hackerrank.com/challenges/mars-exploration/problem
 */
@Singleton
public class MarsExploration {

	private final static String SOS = "SOS";

	public int solve(String sosSignals) {
		int changedLetters = 0;
		int i = 0;
		while (i < sosSignals.length()) {
			for (int j = 0; j < SOS.length(); j++) {
				if (sosSignals.charAt(i++) != SOS.charAt(j)) {
					changedLetters++;
				}
			}
		}
		return changedLetters;
	}

}