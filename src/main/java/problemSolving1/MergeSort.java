package problemSolving1;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 6, 5, 3, 9, 7, 8, 6 };
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a, int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;
			sort(a, l, m);
			sort(a, m + 1, r);
			merge(a, l, m, r);
		}
	}

	public static void merge(int a[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; i++) {
			L[i] = a[i + l];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = a[m + 1 + j];
		}

		/* Merge the temp arrays */
		int i = 0;
		int j = 0;
		int k = l;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		}
	}
}
