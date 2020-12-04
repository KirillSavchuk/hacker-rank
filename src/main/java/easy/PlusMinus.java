package easy;

import com.google.inject.Singleton;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Problem source: https://www.hackerrank.com/challenges/plus-minus/problem
 */
@Singleton
public class PlusMinus {

	private final DecimalFormat df = initDecimalFormat();

	private DecimalFormat initDecimalFormat() {
		DecimalFormat df = new DecimalFormat("0.000000");
		DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		df.setDecimalFormatSymbols(dfs);
		return df;
	}

	public String solve(int[] arr) {
		final int total = arr.length;
		int[] signCount = new int[3];

		for (int el : arr) {
			if (el > 0) {
				signCount[0]++;
			} else if (el < 0) {
				signCount[1]++;
			} else {
				signCount[2]++;
			}
		}

		return Arrays.stream(signCount)
			.mapToDouble(sign -> (double) sign / total)
			.mapToObj(df::format)
			.collect(joining(" "));
	}

}