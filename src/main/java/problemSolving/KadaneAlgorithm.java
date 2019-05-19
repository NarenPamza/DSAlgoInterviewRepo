package problemSolving;

/**
 * Ref: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * @author Admin
 *
 */
public class KadaneAlgorithm {

	public static void main(String[] args) {

		int[] a = {1, 2, 3, -2, 5};
		System.out.println(findMaximumSum(a));

	}

	private static int findMaximumSum(int[] a) {
		int maxSum = 0, max_so_far = 0;

		for (int i = 0; i < a.length; i++) {
			max_so_far = Math.max(0, max_so_far += a[i]);
			maxSum = Math.max(max_so_far, maxSum);
		}
		return maxSum;
	}
}
