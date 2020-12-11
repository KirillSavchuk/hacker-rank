package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsExplorationTest {

	private final MarsExploration marsExploration = new MarsExploration();

	private final Function<String, Integer> solver = marsExploration::solve;

	@MethodSource
	@ParameterizedTest
	void test(String sosSignals, int changedLetters) {
		assertEquals(changedLetters, solver.apply(sosSignals));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("SOSSOT", 1),
			Arguments.of("SOSSOSSOS", 0),
			Arguments.of("SOSSPSSQSSOR", 3)
		);
	}

}