package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoCharactersTest {

	private final TwoCharacters twoCharacters = new TwoCharacters();

	private final Function<String, Integer> solver = twoCharacters::solve;

	@MethodSource
	@ParameterizedTest
	void test(String str, int notAlternatingSequenceMaxLength) {
		assertEquals(notAlternatingSequenceMaxLength, solver.apply(str));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("", 0),
			Arguments.of("aa", 0),
			Arguments.of("abxyba", 3),
			Arguments.of("beabeefeab", 5),
			Arguments.of("abeeabcccabfffababayyyyyybabax", 15),
			Arguments.of("asdcbsdcagfsdbgdfanfghbsfdab", 8),
			Arguments.of("asvkugfiugsalddlasguifgukvsa", 0)
		);
	}

}