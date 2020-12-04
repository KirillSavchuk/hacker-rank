package medium;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StringUtil.toIntMatrix;

class FormingMagicSquareTest {

	private final FormingMagicSquare formingMagicSquare = new FormingMagicSquare();

	private final Function<int[][], Integer> solver = formingMagicSquare::solve;

	@MethodSource
	@ParameterizedTest
	void test(int[][] matrix, int convertingMinimalCost) {
		assertEquals(convertingMinimalCost, solver.apply(matrix));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(toIntMatrix("8 1 6", "3 5 7", "4 9 2"), 0),
			Arguments.of(toIntMatrix("9 1 6", "3 5 7", "4 9 2"), 1),
			Arguments.of(toIntMatrix("5 3 4", "1 5 8", "6 4 2"), 7),
			Arguments.of(toIntMatrix("4 9 2", "3 6 7", "8 1 5"), 2),
			Arguments.of(toIntMatrix("0 0 0", "0 0 0", "0 0 0"), 45)
		);
	}

}