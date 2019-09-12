package problemSolving;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given number of pipes 1..n, Find two largest pipes of maximum length
 * possible. Ex: input - 1,2,3,4,6 Output - The maximum length possible is 8.
 * Pipe1 - 2,6 Pipe2 - 1,3,4
 * 
 *
 */
public class SamsungPipeProblem {

	public static void main(String[] args) {
		Integer[] a = { 20,10,15,90,50,5,4 };

		int sum = 0;
		for (int i : a) {
			sum += i;
		}

		Arrays.sort(a, Collections.reverseOrder());

		System.out.println(findMaxLength(a, sum / 2));

	}

	private static int findMaxLength(Integer[] a, int maxPossibleSum) {

		if (maxPossibleSum < a[a.length - 1]) {
			return 0;
		}

		int firstSum = 0;
		int secondSum = 0;

		boolean isCurrentNumberUsed = false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] < maxPossibleSum) {

				firstSum += a[i];
				isCurrentNumberUsed = true;

				if (firstSum > maxPossibleSum) {
					firstSum -= a[i];
					isCurrentNumberUsed = false;
				}

				if (!isCurrentNumberUsed) {
					secondSum += a[i];

					if (secondSum > maxPossibleSum) {
						secondSum -= a[i];

					}
				}

				isCurrentNumberUsed = false;
			}
		}

		if (firstSum == secondSum) {
			return firstSum;
		} else {
			return findMaxLength(a, maxPossibleSum - 1);
		}
	}
}
