package problemSolving;

/*
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
public class MaxSumAdjHouseRobbery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MaxSumAdjHouseRobbery sum = new MaxSumAdjHouseRobbery();
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		System.out.println(sum.FindMaxSum(arr, arr.length));

	}

	int FindMaxSum(int arr[], int n) {
		int incl = arr[0];
		int excl = 0;

		for (int i = 1; i < n; i++) {
			int excl_new = incl > excl ? incl : excl;
			incl = excl + arr[i];
			excl = excl_new;
		}

		return incl > excl ? incl : excl;

	}

}
