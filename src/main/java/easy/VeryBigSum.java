package easy;

import com.google.inject.Singleton;

import java.util.Arrays;

@Singleton
public class VeryBigSum {

	public long solve(long[] ar) {
		return Arrays.stream(ar).sum();
	}

}