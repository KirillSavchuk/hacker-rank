package easy;

import com.google.inject.Singleton;

import java.util.Stack;

import static java.util.stream.Collectors.joining;

/**
 * Problem source: https://www.hackerrank.com/challenges/reduced-string/problem
 */
@Singleton
public class SuperReducedString {

	public String solve(String str) {
		Stack<Character> chars = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (!chars.isEmpty() && currentChar == chars.lastElement()) {
				chars.pop();
			} else {
				chars.push(str.charAt(i));
			}
		}
		return chars.isEmpty() ? "Empty String" : asString(chars);
	}

	protected String asString(Stack<Character> chars) {
		return chars.stream().map(String::valueOf).collect(joining());
	}

}