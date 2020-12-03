package easy;

import com.google.inject.Singleton;

import java.util.Arrays;

@Singleton
public class SimpleArraySum {

	public int solve(int[] ar) {
		return Arrays.stream(ar).sum();
	}

}