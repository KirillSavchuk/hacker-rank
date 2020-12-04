package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.MatrixUtil.*;

class MatrixUtilTest {

	private final static int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

	@Test
	void test_flipVertically() {
		final int[][] verticallyFlipped = new int[][]{{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
		assertThat(flipVertically(matrix)).isEqualTo(verticallyFlipped);
	}

	@Test
	void test_flipHorizontally() {
		final int[][] horizontallyFlipped = new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
		assertThat(flipHorizontally(matrix)).isEqualTo(horizontallyFlipped);
	}

	@Test
	void test_rotateClockwise() {
		final int[][] clockwiseRotated = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(rotateClockwise(matrix)).isEqualTo(clockwiseRotated);
	}

	@Test
	void test_rotateCounterclockwise() {
		final int[][] counterclockwiseRotated = new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
		assertThat(rotateCounterclockwise(matrix)).isEqualTo(counterclockwiseRotated);
	}

	@Test
	void test_flipMainDiagonal() {
		final int[][] counterclockwiseRotated = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		assertThat(flipMainDiagonal(matrix)).isEqualTo(counterclockwiseRotated);
	}

	@Test
	void test_flipSubDiagonal() {
		final int[][] counterclockwiseRotated = new int[][]{{9, 6, 3}, {8, 5, 2}, {7, 4, 1}};
		assertThat(flipSubDiagonal(matrix)).isEqualTo(counterclockwiseRotated);
	}

}