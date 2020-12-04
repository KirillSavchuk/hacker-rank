package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StringUtil.toIntArray;

class MiniMaxSumTest {

	private final MiniMaxSum miniMaxSum = new MiniMaxSum();

	private final Function<int[], String> solver = miniMaxSum::solve;

	@MethodSource
	@ParameterizedTest
	void test(int[] array, String minMaxSums) {
		assertEquals(minMaxSums, solver.apply(array));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toIntArray("1 2 3"), "3 5"),
			Arguments.of(toIntArray("1 2 3 4 5"), "10 14"),
			Arguments.of(toIntArray("7 69 2 221 8974"), "299 9271")
		);
	}

}