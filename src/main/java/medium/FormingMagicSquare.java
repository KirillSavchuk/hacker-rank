package medium;

import com.google.inject.Singleton;
import util.MatrixUtil;

import java.util.List;

/**
 * Problem source: https://www.hackerrank.com/challenges/magic-square-forming/problem
 */
@Singleton
public class FormingMagicSquare {

	private final static List<int[][]> allSolution = getAllSolutions();

	private static List<int[][]> getAllSolutions() {
		final int[][] uniqueSolution = new int[][]{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
		return MatrixUtil.getAllTransformations(uniqueSolution);
	}

	public int solve(int[][] s) {
		return allSolution.parallelStream()
			.map(solution -> calculateDifference(s, solution))
			.min(Integer::compareTo)
			.orElse(Integer.MAX_VALUE);
	}

	protected int calculateDifference(int[][] source, int[][] destination) {
		final int height = source.length;
		final int width = source[0].length;
		int difference = 0;
		for (int col = 0; col < height; col++) {
			for (int row = 0; row < width; row++) {
				difference += Math.abs(source[col][row] - destination[col][row]);
			}
		}
		return difference;
	}

}