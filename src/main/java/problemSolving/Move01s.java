package problemSolving;

import java.util.Arrays;

/*
 * Move all Zeros to Left and Ones to Right
 */
public class Move01s {
	public static void main(String[] args) {
		int a[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		moveValues(a);
	}

	private static void moveValues(int[] a) {
		int startIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 1) {
				// Swap
				int temp = a[startIndex];
				a[startIndex] = a[i];
				a[i] = temp;
				startIndex++;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
