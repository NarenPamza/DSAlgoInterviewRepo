package problemSolving;

import java.util.Scanner;

/**
 * REf: https://www.geeksforgeeks.org/convert-number-to-words/
 * @author Admin
 *
 */
public class NumberToWord2 {

	static String[] units = new String[] { "", "one", "two", "three", "Four", "Five", "Six", "Seven", "Eight", "Nine"

	};

	static String[] teens = new String[] { "ten", "Eleven", "Tweleve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Ninteen" };

	static String[] tens = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety",

	};

	private static String[] maxs = { "", "", " Hundred", " Thousand", " Lakh", " Crore" };

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {

			System.out.println("Enter the input value");

			String nextLine = in.nextLine();

			System.out.println(nextLine);

			 convertToNumber(nextLine);

		}

	}

	private static void convertToNumber(String nextLine) {

		int pos = 1;
		String converted = "";
		while (nextLine.length() > 0) {

			if (pos == 1) {

				if (nextLine.length() >= 2) {
					String temp = nextLine.substring(nextLine.length() - 2, nextLine.length());
					nextLine = nextLine.substring(0, nextLine.length() - 2);
					converted += digits(temp);
				} else if (nextLine.length() == 1) {
					converted += digits(nextLine);
					nextLine = "";
				}
				pos++;
			} else if (pos == 2) {
				String temp = nextLine.substring(nextLine.length() - 1, nextLine.length());
				nextLine = nextLine.substring(0, nextLine.length() - 1);
				converted =  digits(temp) + maxs[pos] + converted;
				pos++;
			} else {
				
			}

		}

		System.out.println(converted);

	}

	private static String digits(String number) {
		String converted = "";

		char[] charArray = number.toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--) {

			int value = charArray[i] - '0';
			if (i == 0 && value > 1 && number.length() > 1) {
				converted = tens[value] + converted;

			} else if (i == 0 && value == 1 && number.length() == 2) {
				int sum = 0;
				for (int k = 0; k < number.length(); k++) {
					sum = (value * 10) + charArray[k] - '0';
				}
				converted = teens[sum - 10];
			} else {

				converted = units[value];
			}

		}
		return converted;
	}
}