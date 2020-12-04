package easy;

import com.google.inject.Singleton;

import java.util.Arrays;

/**
 * Problem source: https://www.hackerrank.com/challenges/a-very-big-sum/problem
 */
@Singleton
public class VeryBigSum {

	public long solve(long[] ar) {
		return Arrays.stream(ar).sum();
	}

}