package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static util.StringUtil.toIntList;

class BirthdayCakeCandlesTest {

	private final BirthdayCakeCandles birthdayCakeCandles = new BirthdayCakeCandles();

	private final Function<List<Integer>, Integer> solver = birthdayCakeCandles::solve;

	@MethodSource
	@ParameterizedTest
	void test(List<Integer> in, int out) {
		assertThat(solver.apply(in)).isEqualTo(out);
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toIntList("3 2 1 3"), 2),
			Arguments.of(toIntList("5 5 5 5"), 4)
		);
	}

}