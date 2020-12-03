package medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ExtraLongFactorialsTest {

	private final ExtraLongFactorials extraLongFactorials = new ExtraLongFactorials();

	private final Function<Integer, String> solver = extraLongFactorials::solve;

	@MethodSource
	@ParameterizedTest
	void test(int in, String out) {
		assertThat(solver.apply(in)).isEqualTo(out);
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(0, "1"),
			Arguments.of(1, "1"),
			Arguments.of(10, "3628800"),
			Arguments.of(25, "15511210043330985984000000"),
			Arguments.of(36, "371993326789901217467999448150835200000000")
		);
	}

	@Test
	void test_factorial() {
		assertThat(extraLongFactorials.factorial(BigInteger.valueOf(10))).isEqualTo(BigInteger.valueOf(3628800));
	}

}