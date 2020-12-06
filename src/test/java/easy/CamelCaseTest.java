package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCaseTest {

	private final CamelCase camelCase = new CamelCase();

	private final Function<String, Integer> solver = camelCase::solve;

	@MethodSource
	@ParameterizedTest
	void test(String camelCaseStr, int wordCount) {
		assertEquals(wordCount, solver.apply(camelCaseStr));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("", 0),
			Arguments.of("one", 1),
			Arguments.of("oneTwo", 2),
			Arguments.of("saveChangesInTheEditor", 5)
		);
	}

}