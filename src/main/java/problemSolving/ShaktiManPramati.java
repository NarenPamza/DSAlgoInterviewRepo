package problemSolving;

/*
 * https://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
 */
public class ShaktiManPramati {

	public static void main(String[] args) {
		int a[] = { -5, 4, -2, 3, 1 };
		int b[] = { -5, 4, -2, 3, 1, -1, -6, -1, 0, 5 };
		int c[] = { -5, 4, -2, 3, 1, -1, -6, -1, 0, -5 };
		int arr[] = { 4, -10, 4, 4, 4 };
		int d[] = { -1, -5, -9 };

		System.out.println(minInitialEnergy(b));
		System.out.println(minInitialEnergy(a));
		System.out.println(minInitialEnergy(c));
		System.out.println(minInitialEnergy(d));

	}

	static int minInitialEnergy(int arr[]) {

		int n = arr.length;
		// initMinEnergy is variable to store
		// minimum initial energy required.
		int initMinEnergy = 0;

		// currEnergy is variable to store
		// current value of energy at
		// i'th checkpoint on street
		int currEnergy = 0;

		// flag to check if we have successfully
		// crossed the street without any energy
		// loss <= o at any checkpoint
		boolean flag = false;

		// Traverse each check point lineraly
		for (int i = 0; i < n; i++) {
			currEnergy += arr[i];

			// If current energy, becomes negative or 0,
			// increment initial minimum energy by the negative
			// value plus 1. to keep current energy
			// positive (at least 1). Also
			// update current energy and flag.
			if (currEnergy <= 0) {
				initMinEnergy += Math.abs(currEnergy) + 1;
				currEnergy = 1;
				flag = true;
			}
		}

		// If energy never became negative or 0, then
		// return 1. Else return computed initMinEnergy
		return (flag == false) ? 1 : initMinEnergy;
	}

	private static int findCharge(int[] a) {
		int positiveSum = 0;
		int negativeSum = 0;
		int maxPostiveSum = 0;
		boolean isNegativeExist = false;

		for (int i = 0; i < a.length; i++) {

			if (a[i] < 0) {
				isNegativeExist = true;
				negativeSum += a[i];
			} else {
				isNegativeExist = false;
				positiveSum += a[i];
			}

			if (isNegativeExist) {
				maxPostiveSum = positiveSum;
			}
		}

		int maxCharge = Math.abs(negativeSum + maxPostiveSum) + 1;

		if (a[0] < 0 && maxCharge < Math.abs(a[0])) {
			maxCharge = Math.abs(a[0]) + 1;
		}
		return maxCharge;
	}

}
