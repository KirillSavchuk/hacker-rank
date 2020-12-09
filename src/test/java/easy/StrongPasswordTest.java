package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrongPasswordTest {

	private final StrongPassword strongPassword = new StrongPassword();

	private final BiFunction<Integer, String, Integer> solver = strongPassword::solve;

	@MethodSource
	@ParameterizedTest
	void test(int passwordLength, String password, int requiredChanges) {
		assertEquals(requiredChanges, solver.apply(passwordLength, password));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(0, "", 6),
			Arguments.of(6, "aaaaaa", 3),
			Arguments.of(6, "AaAAaA", 2),
			Arguments.of(2, "Aa", 4),
			Arguments.of(11, "#HackerRank", 1),
			Arguments.of(12, "!@#$%^&*()-+", 3),
			Arguments.of(9, "AAA###000", 1),
			Arguments.of(3, "Ab1", 3)
		);
	}

}