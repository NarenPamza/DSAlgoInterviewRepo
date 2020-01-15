package kadaneAlgorithm;

/*
 * https://www.geeksforgeeks.org/container-with-most-water/
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3 };
		System.out.println(findMostWater(a));
	}

	private static int findMostWater(int[] a) {
		int l = 0;
		int r = a.length-1;
		int max = 0;

		while (l < r) {
			max = Math.max(max, Math.min(a[l], a[r]) * (r - l));
			if (a[l] < a[r]) {
				l++;
			} else {
				r--;
			}
		}
		return max;
	}
}
