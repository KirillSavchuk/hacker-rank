package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StringUtil.toLongArray;

class VeryBigSumTest {

	private final VeryBigSum veryBigSum = new VeryBigSum();

	private final Function<long[], Long> solver = veryBigSum::solve;

	@MethodSource
	@ParameterizedTest
	void test(long[] array, long sum) {
		assertEquals(sum, solver.apply(array));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toLongArray("1 2 3"), 6),
			Arguments.of(toLongArray("1000000001 1000000002 1000000003 1000000004 1000000005"), 5000000015L)
		);
	}

}