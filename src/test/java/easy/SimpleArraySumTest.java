package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StringUtil.toIntArray;

class SimpleArraySumTest {

	private final SimpleArraySum simpleArraySum = new SimpleArraySum();

	private final Function<int[], Integer> solver = simpleArraySum::solve;

	@MethodSource
	@ParameterizedTest
	void test(int[] array, int sum) {
		assertEquals(sum, solver.apply(array));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toIntArray("1 2 3"), 6),
			Arguments.of(toIntArray("1 2 3 4 10 11"), 31)
		);
	}

}