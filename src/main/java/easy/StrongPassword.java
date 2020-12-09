package easy;

import com.google.inject.Singleton;

import java.util.Arrays;
import java.util.List;

import static java.lang.Character.*;

/**
 * Problem source: https://www.hackerrank.com/challenges/strong-password/problem
 */
@Singleton
public class StrongPassword {

	public int solve(int strongMinSymbols, String password) {
		PasswordValidator passwordValidator = new PasswordValidator(strongMinSymbols, password);
		passwordValidator.analyze();
		return passwordValidator.getRequiredChangesCount();
	}

	static class PasswordValidator {

		private final int MIN_LENGTH = 6;
		private final int MIN_DIGITS = 1;
		private final int MIN_LOWERCASE_CHARS = 1;
		private final int MIN_UPPERCASE_CHARS = 1;
		private final int MIN_SPECIAL_CHARS = 1;
		private final List<Character> ALLOWED_SPECIAL_CHARS = Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

		private final String password;
		private final int passwordLength;
		private int digitCount = 0;
		private int lowerCaseCharsCount = 0;
		private int upperCaseCharsCount = 0;
		private int specialCharsCount = 0;

		public PasswordValidator(int passwordLength, String password) {
			this.password = password;
			this.passwordLength = passwordLength;
		}

		public void analyze() {
			for (int i = 0; i < password.length(); i++) {
				char currChar = password.charAt(i);
				if (isDigit(currChar)) digitCount++;
				else if (isLowerCase(currChar)) lowerCaseCharsCount++;
				else if (isUpperCase(currChar)) upperCaseCharsCount++;
				else if (ALLOWED_SPECIAL_CHARS.contains(currChar)) specialCharsCount++;
			}
		}

		public int getRequiredChangesCount() {
			int missingRequiredSymbols = getMissingCount(MIN_DIGITS, digitCount) +
				getMissingCount(MIN_LOWERCASE_CHARS, lowerCaseCharsCount) +
				getMissingCount(MIN_UPPERCASE_CHARS, upperCaseCharsCount) +
				getMissingCount(MIN_SPECIAL_CHARS, specialCharsCount);
			return MIN_LENGTH > passwordLength ?
				Math.max(missingRequiredSymbols, getMissingCount(MIN_LENGTH, passwordLength)) :
				missingRequiredSymbols;
		}

		private int getMissingCount(int min, int actual) {
			return min > actual ? min - actual : 0;
		}

	}

}