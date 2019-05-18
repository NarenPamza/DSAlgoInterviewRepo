package problemSolving;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] a = { 1, 5, 4, 3 };
		System.out.println(findMostWater(a));
	}

	private static int findMostWater(int[] a) {
		int maxSum = 0;

		int left = 0;
		int right = a.length - 1;
		while (left < right) {
			maxSum = Math.max(maxSum, Math.min(a[left], a[right]) * (right - left));

			if (a[right] > a[left]) {
				left++;
			} else {
				right--;
			}
		}
		return maxSum;
	}
}
