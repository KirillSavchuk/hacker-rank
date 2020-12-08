package medium;

import io.vavr.Function3;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HighestValuePalindromeTest {

	private final HighestValuePalindrome highestValuePalindrome = new HighestValuePalindrome();

	private final Function3<String, Integer, Integer, String> solver = highestValuePalindrome::solve;

	@ParameterizedTest
	@MethodSource("test")
	void test(String str, int length, int maxModifications, String palindrome) {
		assertEquals(palindrome, solver.apply(str, length, maxModifications));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("5", 1, 1, "9"),
			Arguments.of("777", 3, 0, "777"),
			Arguments.of("3943", 4, 1, "3993"),
			Arguments.of("092282", 6, 3, "992299"),
			Arguments.of("932239", 6, 2, "992299")
		);
	}

	@ParameterizedTest
	@MethodSource("data_setMaxMiddleChar")
	void test_setMaxMiddleChar(char[] chars, char[] modifiedChars) {
		assertArrayEquals(modifiedChars, highestValuePalindrome.setMaxMiddleChar(chars, chars.length));
	}

	private static Stream<Arguments> data_setMaxMiddleChar() {
		return Stream.of(
			Arguments.of("0000".toCharArray(), "0000".toCharArray()),
			Arguments.of("00000".toCharArray(), "00900".toCharArray())
		);
	}

	@ParameterizedTest
	@MethodSource("data_getPalindromeDiffCount")
	void test_getPalindromeDiffCount(char[] chars, int diffCount) {
		assertEquals(diffCount, highestValuePalindrome.getPalindromeDiffCount(chars, chars.length));
	}

	private static Stream<Arguments> data_getPalindromeDiffCount() {
		return Stream.of(
			Arguments.of("".toCharArray(), 0),
			Arguments.of("0".toCharArray(), 0),
			Arguments.of("00".toCharArray(), 0),
			Arguments.of("012345543210".toCharArray(), 0),
			Arguments.of("0123456543210".toCharArray(), 0),
			Arguments.of("0123456789".toCharArray(), 5),
			Arguments.of("01233120".toCharArray(), 2)
		);
	}

}