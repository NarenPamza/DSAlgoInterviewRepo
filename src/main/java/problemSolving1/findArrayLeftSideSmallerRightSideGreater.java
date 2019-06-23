package problemSolving1;

public class findArrayLeftSideSmallerRightSideGreater {

	public static void main(String[] args) {

		// int arr[] = { 7, 2, 5, 9, 10, 11 };

		int[] arr = { 5, 1, 4, 3, 6, 8, 10, 7, 9 };
		System.out.println(findValue(arr));
		System.out.println(element(arr, arr.length));
	}

	// O(n^2)
	private static int findValue(int[] a) {
		int result = -1;

		for (int i = 1; i <= a.length - 2; i++) {

			result = a[i];
			int j = i - 1;
			while (j >= 0) {
				if (a[j] < a[i]) {
					j--;
				} else {
					result = -1;
					break;
				}

			}

			int k = a.length - 1;
			while (k > i) {
				if (a[k] > a[i]) {
					k--;
				} else {
					result = -1;
					break;
				}
			}

			if (result != -1) {
				break;
			}
		}
		return result;
	}

	// O(n)
	public static int element(int ar[], int n) {
		int result = -1;

		int[] left = new int[n];
		left[0] = ar[0];
		int[] right = new int[n];
		right[n - 1] = ar[n - 1];

		for (int i = 1; i < n - 1; i++) {
			left[i] = Math.max(left[i - 1], ar[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.min(right[i + 1], ar[i]);
		}

		for (int i = 1; i < n - 1; i++) {
			if (left[i] == ar[i] && right[i] == ar[i]) {
				return ar[i];
			}
		}

		return result;

	}
}
