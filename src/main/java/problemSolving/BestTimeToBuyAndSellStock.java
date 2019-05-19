package problemSolving;

/*
 * Pattern of Kadane Algorithm
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// Output: 5, since max difference is 6-1 = 5
		int a[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(findMaxProfit(a));

	}

	private static int findMaxProfit(int[] a) {
		int maxSum = 0;
		int max_so_far = 0;

		for (int i = 1; i < a.length; i++) {
			max_so_far = Math.max(0, max_so_far += a[i] - a[i - 1]);
			maxSum = Math.max(max_so_far, maxSum);
		}

		return maxSum;

	}

}
