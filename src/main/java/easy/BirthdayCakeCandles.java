package easy;

import com.google.inject.Singleton;

import java.util.List;

/**
 * Problem source: https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
@Singleton
public class BirthdayCakeCandles {

	public int solve(List<Integer> candles) {
		final Integer maxCandleHeight = candles.stream().max(Integer::compareTo).orElse(0);
		final long candiesWithMaxHeight = candles.stream()
			.filter(candleHeight -> candleHeight.compareTo(maxCandleHeight) == 0)
			.count();
		return (int) candiesWithMaxHeight;
	}

}