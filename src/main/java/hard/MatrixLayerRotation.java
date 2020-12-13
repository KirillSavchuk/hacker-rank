package hard;

import com.google.inject.Singleton;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem source: https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 */
@Singleton
public class MatrixLayerRotation {

	public String solve(List<List<Integer>> listMatrix, long rotationCount) {
		final int totalRows = listMatrix.size();
		final int totalCols = listMatrix.get(0).size();

		int[][] matrix = toMatrix(listMatrix, totalRows, totalCols);
		int[][] newMatrix = copy(matrix, totalRows, totalCols);

		final LayerRotations layerRotations = new LayerRotations(totalRows, totalCols, rotationCount);
		final int totalMatrixLayers = layerRotations.getTotalLayers();

		Map<Integer, Integer> layerRotationMap = layerRotations.getLayerRotations();
		for (int layer = 0; layer < layerRotationMap.size(); layer++) {
			if (layerRotationMap.get(layer) == 0) {
				layerRotationMap.remove(layer);
			}
		}

		while (!layerRotationMap.isEmpty()) {
			for (int layer = 0; layer < totalMatrixLayers; layer++) {
				if (!layerRotationMap.containsKey(layer)) {
					continue;
				}

				int remainingLayerRotations = layerRotationMap.get(layer);
				if (remainingLayerRotations - 1 == 0) {
					layerRotationMap.remove(layer);
				} else {
					layerRotationMap.put(layer, remainingLayerRotations - 1);
				}

				int currTopBorder = layer;
				int currLeftBorder = layer;
				int currBottomBorder = totalRows - layer - 1;
				int currRightBorder = totalCols - layer - 1;

				// TOP side rotation
				for (int col = currRightBorder; col > currLeftBorder; col--) {
					newMatrix[currTopBorder][col - 1] = matrix[currTopBorder][col];
				}
				// BOTTOM side rotation
				for (int col = currLeftBorder; col < currRightBorder; col++) {
					newMatrix[currBottomBorder][col + 1] = matrix[currBottomBorder][col];
				}
				// LEFT	side rotation
				for (int row = currTopBorder; row < currBottomBorder; row++) {
					newMatrix[row + 1][currLeftBorder] = matrix[row][currLeftBorder];
				}
				// RIGHT side rotation
				for (int row = currBottomBorder; row > currTopBorder; row--) {
					newMatrix[row - 1][currRightBorder] = matrix[row][currRightBorder];
				}
			}
			matrix = copy(newMatrix, totalRows, totalCols);
		}
		String prettyPrintedMatrix = prettyPrint(matrix);
		System.out.println(prettyPrintedMatrix);
		return prettyPrintedMatrix;
	}

	@Getter
	public static class LayerRotations {

		private final int totalLayers;
		private final Map<Integer, Integer> layerRotations;

		public LayerRotations(int matrixRows, int matrixCols, long rotationCount) {
			this.totalLayers = calculateTotalLayers(matrixRows, matrixCols);
			this.layerRotations = calculateLayerRotations(matrixRows, matrixCols, rotationCount);
		}

		private int calculateTotalLayers(int matrixRows, int matrixCols) {
			return (int) Math.ceil(Math.min(matrixRows, matrixCols) / 2.0);
		}

		private Map<Integer, Integer> calculateLayerRotations(int matrixRows, int matrixCols, long rotationCount) {
			Map<Integer, Integer> layerRotationsMap = new HashMap<>();
			for (int layer = 0; layer < this.totalLayers; layer++) {
				int layerRotations = rotationsModulo(rotationCount, matrixRows - 2 * layer, matrixCols - 2 * layer);
				layerRotationsMap.put(layer, layerRotations);
			}
			return layerRotationsMap;
		}

		private int rotationsModulo(long rotations, int rows, int cols) {
			int perimeter = (rows - 1) * 2 + (cols - 1) * 2;
			return perimeter != 0 ?
				(int) rotations % perimeter :
				(int) rotations;
		}

	}

	private int[][] toMatrix(List<List<Integer>> listMatrix, int rows, int cols) {
		int[][] matrix = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			List<Integer> currRow = listMatrix.get(row);
			for (int col = 0; col < cols; col++) {
				matrix[row][col] = currRow.get(col);
			}
		}
		return matrix;
	}

	private int[][] copy(int[][] srcArr, int rows, int cols) {
		int[][] destArr = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				destArr[r][c] = srcArr[r][c];
			}
		}
		return destArr;
	}

	private String prettyPrint(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		final int height = arr.length;
		final int width = arr[0].length;
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				sb.append(arr[h][w]);
				if (w != width - 1) {
					sb.append(" ");
				}
			}
			if (h != height - 1) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}

}