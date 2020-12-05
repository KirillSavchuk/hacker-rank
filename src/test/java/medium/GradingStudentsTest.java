package medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.ArrayUtil.asList;
import static util.StringUtil.toIntArray;

class GradingStudentsTest {

	private final GradingStudents gradingStudents = new GradingStudents();

	private final Function<List<Integer>, List<Integer>> solver = gradingStudents::solve;

	@MethodSource
	@ParameterizedTest
	void test(List<Integer> initialGrades, List<Integer> finalGrades) {
		assertEquals(finalGrades, solver.apply(initialGrades));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(asList(toIntArray("84 29 57")), asList(toIntArray("85 29 57"))),
			Arguments.of(asList(toIntArray("73 67 38 33")), asList(toIntArray("75 67 40 33")))
		);
	}

	@Test
	void test_calculateGrade() {
		assertThat(gradingStudents.calculateGrade(84)).isEqualTo(85);
	}

}