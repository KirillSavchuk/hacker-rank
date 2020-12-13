package hard;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ArrayUtil.asListMatrix;
import static util.StringUtil.toIntMatrix;

class MatrixLayerRotationTest {

	private final MatrixLayerRotation matrixLayerRotation = new MatrixLayerRotation();

	private final BiFunction<List<List<Integer>>, Long, String> solver = matrixLayerRotation::solve;

	@ParameterizedTest
	@MethodSource("test")
	void test(long rotationCount, List<List<Integer>> listMatrix, String rotatedMatrix) {
		assertEquals(rotatedMatrix, solver.apply(listMatrix, rotationCount));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(3, asListMatrix(toIntMatrix(
				"1 1",
				"1 1")),
				"1 1\n1 1"),
			Arguments.of(2, asListMatrix(toIntMatrix(
				"1 2",
				"4 3")),
				"3 4\n2 1"),
			Arguments.of(2, asListMatrix(toIntMatrix(
				"1 2 3 4",
				"5 6 7 8",
				"9 10 11 12",
				"13 14 15 16")),
				"3 4 8 12\n2 11 10 16\n1 7 6 15\n5 9 13 14"),
			Arguments.of(40, asListMatrix(toIntMatrix(
				"9718805 60013003 5103628 85388216 21884498 38021292 73470430 31785927",
				"69999937 71783860 10329789 96382322 71055337 30247265 96087879 93754371",
				"79943507 75398396 38446081 34699742 1408833 51189 17741775 53195748",
				"79354991 26629304 86523163 67042516 54688734 54630910 6967117 90198864",
				"84146680 27762534 6331115 5932542 29446517 15654690 92837327 91644840",
				"58623600 69622764 2218936 58592832 49558405 17112485 38615864 32720798",
				"49469904 5270000 32589026 56425665 23544383 90502426 63729346 35319547",
				"20888810 97945481 85669747 88915819 96642353 42430633 47265349 89653362",
				"55349226 10844931 25289229 90786953 22590518 54702481 71197978 50410021",
				"9392211 31297360 27353496 56239301 7071172 61983443 86544343 43779176")),
				"93754371 53195748 90198864 91644840 32720798 35319547 89653362 50410021\n" +
				"31785927 25289229 10844931 97945481 5270000 69622764 27762534 43779176\n" +
				"73470430 90786953 42430633 96642353 88915819 85669747 26629304 86544343\n" +
				"38021292 22590518 90502426 67042516 54688734 32589026 75398396 61983443\n" +
				"21884498 54702481 17112485 5932542 29446517 2218936 71783860 7071172\n" +
				"85388216 71197978 15654690 58592832 49558405 6331115 10329789 56239301\n" +
				"5103628 47265349 54630910 56425665 23544383 86523163 96382322 27353496\n" +
				"60013003 63729346 51189 1408833 34699742 38446081 71055337 31297360\n" +
				"9718805 38615864 92837327 6967117 17741775 96087879 30247265 9392211\n" +
				"69999937 79943507 79354991 84146680 58623600 49469904 20888810 55349226")
		);
	}

	@ParameterizedTest
	@MethodSource("data_LayerRotations")
	void test_LayerRotations(int rows, int cols, long rotationCount, int expectedTotalLayers) {
		MatrixLayerRotation.LayerRotations layerRotations = new MatrixLayerRotation.LayerRotations(rows, cols, rotationCount);
		assertEquals(expectedTotalLayers, layerRotations.getTotalLayers());
	}

	private static Stream<Arguments> data_LayerRotations() {
		return Stream.of(
			Arguments.of(2, 2, 1L, 1),
			Arguments.of(2, 2, 5L, 1),
			Arguments.of(5, 5, 1000L, 3),
			Arguments.of(6, 9, 12345L, 3)
		);
	}

}