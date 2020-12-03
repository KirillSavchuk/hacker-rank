package easy;

import com.google.inject.Singleton;

@Singleton
public class MiniMaxSum {

	public String solve(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		int totalSum = 0;
		for (int n : arr) {
			totalSum += n;
			if (n < min) min = n;
			if (n > max) max = n;
		}
		return String.format("%s %s", totalSum - max, totalSum - min);
	}

}