package problemSolving;

public class CountAndSayAtlassian {

	public static void main(String[] args) {
		int n = 7;
		/*
		 * 11 
		 * 21 
		 * 1211 
		 * 111221 
		 * 312211 
		 * 13112221
		 */
		countAndSay(n);
	}

	private static void countAndSay(int n) {

		StringBuilder prevResult = new StringBuilder("1");

		for (int i = 0; i < n - 1; i++) { // Out Loop for total N

			StringBuilder current = prevResult;
			prevResult = new StringBuilder();
			char[] charArray = current.toString().toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				int count = 1;
				char a = charArray[j];

				for (int k = j + 1; k < charArray.length; k++) {

					if (charArray[k] == a) {
						count++;
						j++;
					} else {
						break;
					}

				}
				prevResult.append(count).append(a);
			}
			System.out.println(prevResult);
		}
	}
}
