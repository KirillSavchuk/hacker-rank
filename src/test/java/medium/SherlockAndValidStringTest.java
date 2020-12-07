package medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SherlockAndValidStringTest {

	private final SherlockAndValidString sherlockAndValidString = new SherlockAndValidString();

	private final Function<String, String> solver = sherlockAndValidString::solve;

	@MethodSource
	@ParameterizedTest
	void test(String str, String isValid) {
		assertEquals(isValid, solver.apply(str));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("", "YES"),
			Arguments.of("abbac", "YES"),
			Arguments.of("aabbcd", "NO"),
			Arguments.of("aabbccddeefghi", "NO"),
			Arguments.of("aaabbbcccc", "YES"),
			Arguments.of("aaaabbbbccc", "NO"),
			Arguments.of("abcdefghhgfedecba", "YES")
		);
	}

}