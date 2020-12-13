package hard;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

/**
 * Problem source: https://www.hackerrank.com/challenges/find-strings/problem
 * <br/>
 * Tests passed: 4/8. Issue: Time limit exceeded.
 */
@Singleton
public class FindStringsSlow {

	public String[] solve(String[] strings, int[] queries) {
		final List<String> substrings = getSortedSubstrings(strings);
		return Arrays.stream(queries)
			.map(pos -> pos - 1)
			.mapToObj(pos -> getElement(substrings, pos))
			.toArray(String[]::new);
	}

	protected List<String> getSortedSubstrings(String[] strings) {
		return Arrays.stream(strings)
			.map(this::getSubstrings)
			.flatMap(List::stream)
			.distinct()
			.sorted(naturalOrder())
			.collect(toList());
	}

	protected List<String> getSubstrings(String str) {
		List<String> substrings = new ArrayList<>();
		for (int from = 0; from <= str.length(); from++) {
			for (int to = from + 1; to <= str.length(); to++) {
				substrings.add(str.substring(from, to));
			}
		}
		return substrings;
	}

	protected String getElement(List<String> list, int pos) {
		return (pos >= 0 && pos < list.size()) ? list.get(pos) : "INVALID";
	}

}