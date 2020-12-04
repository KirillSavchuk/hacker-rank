package util;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringUtil {

	private final static String DEFAULT_STRING_DIVIDER = " ";

	public static int[][] toIntMatrix(String... strings) {
		int[][] matrix = new int[strings.length][];
		int counter = 0;
		for (String str : strings) {
			matrix[counter++] = toIntArray(str);
		}
		return matrix;
	}

	public static int[] toIntArray(String str) {
		return split(str).mapToInt(Integer::valueOf).toArray();
	}

	public static long[] toLongArray(String str) {
		return split(str).mapToLong(Long::valueOf).toArray();
	}

	public static double[] toDoubleArray(String str) {
		return split(str).mapToDouble(Double::valueOf).toArray();
	}

	public static String[] toStringArray(String str) {
		return split(str).toArray(String[]::new);
	}

	private static Stream<String> split(String str) {
		return Arrays.stream(str.split(DEFAULT_STRING_DIVIDER));
	}

}
