package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ArrayUtil.asList;
import static util.StringUtil.toIntArray;

class BirthdayCakeCandlesTest {

	private final BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

	private final Function<List<Integer>, Integer> solver = birthdayCakeCandles::solve;

	@MethodSource
	@ParameterizedTest
	void test(List<Integer> candleHeights, int tallestCandlesCount) {
		assertEquals(tallestCandlesCount, solver.apply(candleHeights));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(asList(toIntArray("3 2 1 3")), 2),
			Arguments.of(asList(toIntArray("5 5 5 5")), 4)
		);
	}

}