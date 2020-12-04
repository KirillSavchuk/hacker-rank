package medium;

import com.google.inject.Singleton;

import java.math.BigInteger;

/**
 * Problem source: https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
@Singleton
public class ExtraLongFactorials {

	public String solve(int n) {
		return factorial(BigInteger.valueOf(n)).toString();
	}

	protected BigInteger factorial(BigInteger bigN) {
		if (bigN.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {
			return bigN.multiply(factorial(bigN.subtract(BigInteger.ONE)));
		}
	}

}