package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunnyStringTest {

	private final FunnyString funnyString = new FunnyString();

	private final Function<String, String> solver = funnyString::solve;

	@MethodSource
	@ParameterizedTest
	void test(String str, String isFunnyString) {
		assertEquals(isFunnyString, solver.apply(str));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of("acxz", "Funny"),
			Arguments.of("bcxz", "Not Funny"),
			Arguments.of("ivvkxq", "Not Funny"),
			Arguments.of("pryumtuntmovpwvowslj", "Funny"),
			Arguments.of("nosklrxrtyuxtmnurzsryuxtywqwqpxts", "Not Funny"),
			Arguments.of("ovyvzvptyvpvpxyztlrztsrztztqvrxtxuxq", "Funny")
		);
	}

}