package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static util.StringUtil.toIntArray;

class PlusMinusTest {

	private final PlusMinus plusMinus = new PlusMinus();

	private final Function<int[], String> solver = plusMinus::solve;

	@MethodSource
	@ParameterizedTest
	void test(int[] in, String out) {
		assertThat(solver.apply(in)).isEqualTo(out);
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toIntArray("-1 0 1"), "0.333333 0.333333 0.333333"),
			Arguments.of(toIntArray("1 1 1 1 1 1"), "1.000000 0.000000 0.000000"),
			Arguments.of(toIntArray("-4 3 -9 0 4 1"), "0.500000 0.333333 0.166667"),
			Arguments.of(toIntArray("1 2 3 -1 -2 -3 0 0"), "0.375000 0.375000 0.250000")
		);
	}

}