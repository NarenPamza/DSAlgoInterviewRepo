package problemSolving;

import java.util.Arrays;

// Move all Zeros to LEft and Non Zero to Right
public class MoveZeroAndNonZeroNumber {
	public static void main(String[] args) {
		int a[] = { 0, 2, 1, 0, 4, 5, 0, 7, 5, 0, 0, 9 };
		moveValues(a);
	}

	private static void moveValues(int[] a) {
		int startIndex = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != 0) {
				// Swap
				int temp = a[startIndex];
				a[startIndex] = a[i];
				a[i] = temp;
				startIndex--;
			}
		}
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a) {
		int count = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != 0) {
				a[count--] = a[i];
				System.out.println(Arrays.toString(a));
			}
		}
		while (count >= 0) {
			a[count--] = 0;
		}
		System.out.println(Arrays.toString(a));
	}
}
