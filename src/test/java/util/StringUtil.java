package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtil {

	private final static String DEFAULT_STRING_DIVIDER = " ";

	public static List<Integer> toIntList(String str) {
		return Arrays.stream(toIntArray(str)).boxed().collect(Collectors.toList());
	}

	public static List<Long> toLongList(String str) {
		return Arrays.stream(toLongArray(str)).boxed().collect(Collectors.toList());
	}

	public static List<Double> toDoubleList(String str) {
		return Arrays.stream(toDoubleArray(str)).boxed().collect(Collectors.toList());
	}

	public static List<String> toStringList(String str) {
		return Arrays.stream(toStringArray(str)).collect(Collectors.toList());
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
