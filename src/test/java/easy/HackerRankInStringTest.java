package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HackerRankInStringTest {

	private final HackerRankInString hackerRankInString = new HackerRankInString();

	private final Function<String, String> solver = hackerRankInString::solve;

	@MethodSource
	@ParameterizedTest
	void test(String str, String contains) {
		assertEquals(contains, solver.apply(str));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("hackerrank", "YES"),
			Arguments.of("hereiamstackerrank", "YES"),
			Arguments.of("hackerworld", "NO"),
			Arguments.of("hhaacckkekraraannk", "YES"),
			Arguments.of("rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt", "NO")
		);
	}

}