package easy;

import com.google.inject.Singleton;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

/**
 * Problem source: https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 */
@Singleton
public class CaesarCipher {

	private static final char LETTER_A_LOWER = 'a';
	private static final char LETTER_A_UPPER = 'A';
	private static final char LETTER_Z_LOWER = 'z';
	private static final char LETTER_Z_UPPER = 'Z';
	private static final int ALPHABET_SIZE = 26;

	public String solve(String text, int rotationFactor) {
		rotationFactor %= ALPHABET_SIZE;
		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char ch = text.charAt(i);
			if (isLowerCase(ch)) {
				chars[i] = rotateChar(ch, rotationFactor, LETTER_A_LOWER, LETTER_Z_LOWER);
			} else if (isUpperCase(ch)) {
				chars[i] = rotateChar(ch, rotationFactor, LETTER_A_UPPER, LETTER_Z_UPPER);
			}
		}
		return new String(chars);
	}

	private char rotateChar(char ch, int rotationFactor, char fromChar, char toChar) {
		ch += rotationFactor;
		if (ch < fromChar) {
			return (char) (ch + ALPHABET_SIZE);
		}
		if (ch > toChar) {
			return (char) (ch - ALPHABET_SIZE);
		}
		return ch;
	}

}