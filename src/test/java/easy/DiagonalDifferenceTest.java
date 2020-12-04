package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ArrayUtil.asListMatrix;
import static util.StringUtil.toIntMatrix;

class DiagonalDifferenceTest {

	private final DiagonalDifference diagonalDifference = new DiagonalDifference();

	private final Function<List<List<Integer>>, Integer> solver = diagonalDifference::solve;

	@MethodSource
	@ParameterizedTest
	void test(List<List<Integer>> matrix, int absDiagonalDiff) {
		assertEquals(absDiagonalDiff, solver.apply(matrix));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(asListMatrix(toIntMatrix("1")), 0),
			Arguments.of(asListMatrix(toIntMatrix("0 0", "0 0")), 0),
			Arguments.of(asListMatrix(toIntMatrix("5 0", "0 5")), 10),
			Arguments.of(asListMatrix(toIntMatrix("0 5", "5 0")), 10),
			Arguments.of(asListMatrix(toIntMatrix("11 2 4", "4 5 6", "10 8 -12")), 15)
		);
	}

}