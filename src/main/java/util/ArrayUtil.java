package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayUtil {

	public static List<List<Integer>> asListMatrix(int[][] arr) {
		return Stream.of(arr).map(ArrayUtil::asList).collect(toList());
	}

	public static List<Integer> asList(int[] arr) {
		return Arrays.stream(arr).boxed().collect(toList());
	}

	public static List<Long> asList(long[] arr) {
		return Arrays.stream(arr).boxed().collect(toList());
	}

	public static List<Double> asList(double[] arr) {
		return Arrays.stream(arr).boxed().collect(toList());
	}

	public static List<String> asList(String[] arr) {
		return Arrays.stream(arr).collect(toList());
	}

}