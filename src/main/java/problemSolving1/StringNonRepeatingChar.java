package problemSolving1;

// Java program to find first non-repeating character 

class StringNonRepeatingChar {

	/*
	 * Best Approach for all
	 */
	public static int firstUniqChar2(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int result = Integer.MAX_VALUE;
		int fIndex = -1, lIndex = -1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			fIndex = s.indexOf(ch);
			lIndex = s.lastIndexOf(ch);
			if (fIndex != -1 && fIndex == lIndex) {
				result = Integer.min(fIndex, result);
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	// Driver method
	public static void main(String[] args) {
		String str = "acDca";
		// Best Approach
		System.out.println(firstUniqChar2(str.toLowerCase()));
	}
}
