package medium;

import com.google.inject.Singleton;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Problem source: https://www.hackerrank.com/challenges/grading/problem
 */
@Singleton
public class GradingStudents {

	private final static int NO_ROUND_GRADE = 38;


	public List<Integer> solve(List<Integer> grades) {
		return grades.stream().map(this::calculateGrade).collect(toList());
	}

	protected int calculateGrade(int grade) {
		int gradeMod5 = 5 - Math.floorMod(grade, 5);
		if (grade < NO_ROUND_GRADE || gradeMod5 >= 3) {
			return grade;
		} else {
			return grade + gradeMod5;
		}
	}

}