package problemSolving1;

public class IndexOfStringPattern {

	public static void main(String[] args) {

		String input = "naren";

		// int startIndex = findStartingIndexOfStringPatternInString(input,
		// "re");

		System.out.println(isPatternMatching(input, "n*n"));

		// System.out.println(startIndex);

	}

	private static boolean isPatternMatching(String input, String pattern) {

		boolean result = false;

		char[] patternArray = pattern.toCharArray();
		int leftIndex = -1;
		int rightIndex = -1;

		if (patternArray[0] != '*') {
			leftIndex = findStartingIndexOfStringPatternInString(input, patternArray[0] + "");
		} else if (patternArray[0] == '*') {
			leftIndex = 0;
		}

		if (patternArray[pattern.length() - 1] != '*') {
			rightIndex = findStartingIndexOfStringPatternInString(input, patternArray[pattern.length() - 1] + "");
		} else if (patternArray[pattern.length() - 1] == '*') {
			rightIndex = Integer.MAX_VALUE;
		}

		if ((leftIndex != -1 && leftIndex < rightIndex) || (leftIndex != -1 && rightIndex == Integer.MAX_VALUE)) {
			return true;
		}

		return result;
	}

	private static int findStartingIndexOfStringPatternInString(String input, String pattern) {
		int startIndex = -1;
		char[] charArray = input.toCharArray();
		char[] patternArray = pattern.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == patternArray[0]) {
				int j = i + 1;
				startIndex = i;

				if (1 == pattern.length()) {
					return startIndex;
				}

				for (int k = 1; k < patternArray.length; k++) {
					if (charArray[j] == patternArray[k]) {
						if (k == pattern.length() - 1) {
							return startIndex;
						}
						j++;
						continue;
					} else {
						break;
					}
				}
			}
		}
		return -1;
	}
}
