package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class MatrixUtil {

	public static void prettyPrint(int[][] arr) {
		final int height = arr.length;
		final int width = arr[0].length;
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				System.out.print(arr[h][w]);
			}
			System.out.println();
		}
	}

	public static int[][] flipVertically(int[][] arr) {
		final Function<MatrixData, Integer> transformCol = MatrixData::getCol;
		final Function<MatrixData, Integer> transformRow = data -> data.getWidth() - data.getRow() - 1;
		return transform(arr, transformCol, transformRow);
	}

	public static int[][] flipHorizontally(int[][] arr) {
		final Function<MatrixData, Integer> transformCol = data -> data.getHeight() - data.getCol() - 1;
		final Function<MatrixData, Integer> transformRow = MatrixData::getRow;
		return transform(arr, transformCol, transformRow);
	}

	public static int[][] rotateClockwise(int[][] arr) {
		final Function<MatrixData, Integer> transformCol = data -> data.getHeight() - data.getRow() - 1;
		final Function<MatrixData, Integer> transformRow = MatrixData::getCol;
		return transform(arr, transformCol, transformRow);
	}

	public static int[][] rotateCounterclockwise(int[][] arr) {
		final Function<MatrixData, Integer> transformCol = MatrixData::getRow;
		final Function<MatrixData, Integer> transformRow = data -> data.getWidth() - data.getCol() - 1;
		return transform(arr, transformCol, transformRow);
	}

	public static int[][] flipMainDiagonal(int[][] arr) {
		return rotateClockwise(flipHorizontally(arr));
	}

	public static int[][] flipSubDiagonal(int[][] arr) {
		return rotateCounterclockwise(flipHorizontally(arr));
	}

	public static List<int[][]> getAllTransformations(int[][] arr) {
		List<int[][]> transformations = new ArrayList<>();
		transformations.add(arr);
		transformations.add(flipVertically(arr));
		transformations.add(flipHorizontally(arr));
		transformations.add(flipHorizontally(flipVertically(arr)));
		transformations.add(flipMainDiagonal(arr));
		transformations.add(flipSubDiagonal(arr));
		transformations.add(rotateClockwise(arr));
		transformations.add(rotateCounterclockwise(arr));
		return transformations;
	}

	private static int[][] transform(int[][] arr, Function<MatrixData, Integer> transformCol, Function<MatrixData, Integer> transformRow) {
		final int height = arr.length;
		final int width = arr[0].length;
		int[][] res = new int[height][width];
		for (int col = 0; col < height; col++) {
			for (int row = 0; row < width; row++) {
				final MatrixData data = new MatrixData(height, width, col, row);
				res[col][row] = arr[transformCol.apply(data)][transformRow.apply(data)];
			}
		}
		return res;
	}

	static class MatrixData {
		public final int height;
		public final int width;
		public final int col;
		public final int row;

		public MatrixData(int height, int width, int col, int row) {
			this.height = height;
			this.width = width;
			this.col = col;
			this.row = row;
		}

		public int getHeight() {
			return this.height;
		}

		public int getWidth() {
			return this.width;
		}

		public int getCol() {
			return this.col;
		}

		public int getRow() {
			return this.row;
		}
	}

}