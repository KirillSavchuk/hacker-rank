package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperReducedStringTest {

	private final SuperReducedString superReducedString = new SuperReducedString();

	private final Function<String, String> solver = superReducedString::solve;

	@MethodSource
	@ParameterizedTest
	void test(String str, String reducedStr) {
		assertEquals(reducedStr, solver.apply(str));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("aaabccddd", "abd"),
			Arguments.of("baab", "Empty String")
		);
	}

}