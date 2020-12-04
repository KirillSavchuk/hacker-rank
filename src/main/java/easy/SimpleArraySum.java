package easy;

import com.google.inject.Singleton;

import java.util.Arrays;

/**
 * Problem source: https://www.hackerrank.com/challenges/simple-array-sum/problem
 */
@Singleton
public class SimpleArraySum {

	public int solve(int[] ar) {
		return Arrays.stream(ar).sum();
	}

}