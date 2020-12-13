package easy;

import com.google.inject.Singleton;

/**
 * Problem source: https://www.hackerrank.com/challenges/simple-array-sum/problem
 */
@Singleton
public class ChessboardGame {

	public String solve(int posX, int poxY) {
		return player1Wins(posX, poxY) ? "First" : "Second";
	}

	private boolean player1Wins(int posX, int poxY) {
		int modX = posX % 4;
		int modY = poxY % 4;
		return modX == 0 || modX == 3 || modY == 0 || modY == 3;
	}

}