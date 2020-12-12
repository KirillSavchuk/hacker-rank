package expert;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static util.StringUtil.toIntArray;
import static util.StringUtil.toStringArray;

class FindStringsTest {

	private final FindStrings findStrings = new FindStrings();

	private final BiFunction<String[], int[], String[]> solver = findStrings::solve;

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

}