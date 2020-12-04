package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StaircaseTest {

	private final Staircase staircase = new Staircase();

	private final Function<Integer, String> solver = staircase::solve;

	@MethodSource
	@ParameterizedTest
	void test(int stairsCount, String stairsView) {
		assertEquals(stairsView, solver.apply(stairsCount));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(0, ""),
			Arguments.of(1, "#"),
			Arguments.of(4, "   #\n  ##\n ###\n####")
		);
	}

	@Test
	void test_repeat() {
		assertThat(staircase.repeat("#", 3)).isEqualTo("###");
	}

}