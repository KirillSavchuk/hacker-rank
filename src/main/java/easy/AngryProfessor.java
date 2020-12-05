package easy;

import com.google.inject.Singleton;

import java.util.Arrays;

/**
 * Problem source: https://www.hackerrank.com/challenges/angry-professor/problem
 */
@Singleton
public class AngryProfessor {

	public String solve(int minStudentsOnTime, int[] studentsArrivalTime) {
		return isClassCanceled(minStudentsOnTime, studentsArrivalTime) ? "YES" : "NO";
	}

	protected boolean isClassCanceled(int minStudentsOnTime, int[] studentsArrivalTime) {
		return minStudentsOnTime > getStudentOnTimeCount(studentsArrivalTime);
	}

	protected int getStudentOnTimeCount(int[] studentsArrivalTime) {
		return (int) Arrays.stream(studentsArrivalTime)
			.filter(studentTime -> studentTime <= 0)
			.count();
	}

}