package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.StringUtil.toIntArray;

class AngryProfessorTest {

	private final AngryProfessor angryProfessor = new AngryProfessor();

	private final BiFunction<Integer, int[], String> solver = angryProfessor::solve;

	@ParameterizedTest
	@MethodSource("test")
	void test(int minStudentsOnTime, int[] studentsArrivalTime, String classIsCanceled) {
		assertEquals(classIsCanceled, solver.apply(minStudentsOnTime, studentsArrivalTime));
	}

	private static Stream<Arguments> test() {
		return Stream.of(
			Arguments.of(3, toIntArray("-1 -3 4 2"), "YES"),
			Arguments.of(2, toIntArray("0 -1 2 1"), "NO")
		);
	}

	@ParameterizedTest
	@MethodSource("data_getStudentOnTimeCount")
	void test_getStudentOnTimeCount(int[] studentsArrivalTime, int studentOnTimeCount) {
		assertEquals(studentOnTimeCount, angryProfessor.getStudentOnTimeCount(studentsArrivalTime));
	}

	private static Stream<Arguments> data_getStudentOnTimeCount() {
		return Stream.of(
			Arguments.of(toIntArray("0 0 0"), 3),
			Arguments.of(toIntArray("1 2 3"), 0),
			Arguments.of(toIntArray("-1 -2 -3"), 3)
		);
	}

}