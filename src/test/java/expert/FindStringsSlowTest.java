package expert;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ArrayUtil.asList;
import static util.StringUtil.toIntArray;
import static util.StringUtil.toStringArray;

class FindStringsSlowTest {

	private final FindStringsSlow findStringsSlow = new FindStringsSlow();

	private final BiFunction<String[], int[], String[]> solver = findStringsSlow::solve;

	@ParameterizedTest
	@MethodSource("test")
	void test(String[] strings, int[] positions, String[] searchedSubstrings) {
		assertArrayEquals(searchedSubstrings, solver.apply(strings, positions));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toStringArray("aab aac"), toIntArray("3 8 23"), toStringArray("aab c INVALID")),
			Arguments.of(toStringArray("abc cd"), toIntArray("1 5 7"), toStringArray("a bc cd"))
		);
	}

	@ParameterizedTest
	@MethodSource("data_getSubstrings")
	void test_getSubstrings(String str, List<String> substrings) {
		assertEquals(substrings, findStringsSlow.getSubstrings(str));
	}

	private static Stream<Arguments> data_getSubstrings() {
		return Stream.of(
			Arguments.of("", emptyList()),
			Arguments.of("aaa", asList(toStringArray("a aa aaa a aa a"))),
			Arguments.of("abc", asList(toStringArray("a ab abc b bc c")))
		);
	}

	@ParameterizedTest
	@MethodSource("data_getElement")
	void test_getElement(List<String> elements, int position, String foundString) {
		assertEquals(foundString, findStringsSlow.getElement(elements, position));
	}

	private static Stream<Arguments> data_getElement() {
		final String INVALID = "INVALID";
		return Stream.of(
			Arguments.of(emptyList(), 0, INVALID),
			Arguments.of(asList(toStringArray("a b c d")), 0, "a"),
			Arguments.of(asList(toStringArray("a b c d")), 3, "d"),
			Arguments.of(asList(toStringArray("a b c d")), 4, INVALID),
			Arguments.of(asList(toStringArray("a b c d")), -1, INVALID)
		);
	}

}