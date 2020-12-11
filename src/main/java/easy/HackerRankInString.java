package easy;

import com.google.inject.Singleton;

import java.util.Stack;

/**
 * Problem source: https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
@Singleton
public class HackerRankInString {

	private final static String HACKER_RANK = "hackerrank";

	public String solve(String str) {
		final Stack<Character> charsToFind = toCharStack(HACKER_RANK);
		return containsChars(str, charsToFind) ? "YES" : "NO";
	}

	private Stack<Character> toCharStack(String str) {
		Stack<Character> chars = new Stack<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			chars.add(str.charAt(i));
		}
		return chars;
	}

	private boolean containsChars(String str, Stack<Character> charsToFind) {
		char charToFind = charsToFind.pop();
		for (char ch : str.toCharArray()) {
			if (ch == charToFind) {
				if (charsToFind.isEmpty()) {
					return true;
				} else {
					charToFind = charsToFind.pop();
				}
			}
		}
		return false;
	}

}