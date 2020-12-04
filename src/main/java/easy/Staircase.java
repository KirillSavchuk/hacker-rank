package easy;

import com.google.inject.Singleton;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * Problem source: https://www.hackerrank.com/challenges/staircase/problem
 */
@Singleton
public class Staircase {

	public String solve(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(repeat(" ", n - i)).append(repeat("#", i));
			if (i != n) sb.append("\n");
		}
		return sb.toString();
	}

	protected String repeat(CharSequence symbols, int times) {
		return IntStream.range(0, times)
			.mapToObj(i -> symbols)
			.collect(joining());
	}

}