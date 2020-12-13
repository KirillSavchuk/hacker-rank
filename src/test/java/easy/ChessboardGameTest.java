package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessboardGameTest {

	private final ChessboardGame chessboardGame = new ChessboardGame();

	private final BiFunction<Integer, Integer, String> solver = chessboardGame::solve;

	@MethodSource
	@ParameterizedTest
	void test(int posX, int poxY, String winner) {
		assertEquals(winner, solver.apply(posX, poxY));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(5, 2, "Second"),
			Arguments.of(5, 3, "First"),
			Arguments.of(8, 8, "First"),
			Arguments.of(8, 12, "First")
		);
	}

}