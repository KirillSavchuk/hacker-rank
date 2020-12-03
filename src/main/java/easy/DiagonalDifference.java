package easy;

import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class DiagonalDifference {

	public int solve(List<List<Integer>> arr) {
		final int matrixSize = arr.size();
		int mainDiagonalSum = 0;
		int subDiagonalSum = 0;
		for (int i = 0; i < matrixSize; i++) {
			subDiagonalSum += arr.get(i).get(matrixSize - i - 1);
			mainDiagonalSum += arr.get(i).get(i);
		}
		return Math.abs(mainDiagonalSum - subDiagonalSum);
	}

}