package dp;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.
 */
public class CoinChange {

	static long countWays(int S[], int m, int n) {
		int a[] = new int[n + 1];

		Arrays.fill(a, 0);

		a[0] = 1;

		for (int i = 0; i < m; i++) {

			System.out.println("Combination---start--");
			for (int j = S[i]; j <= n; j++) {
				
				System.out.println("J value is "+ j + " s[i] is " + S[i] + " j - S[i] is " + (j - S[i]) + " & a[j - S[i]] is " + a[j - S[i]] );
				a[j] += a[j - S[i]];
				System.out.println(Arrays.toString(a));
				
			}
			System.out.println(Arrays.toString(a));
			System.out.println("Combination---End--");
		}

		return a[n];
	}

	// Driver Function to test above function
	public static void main(String args[]) {
		int arr[] = {  5,7,3,2,9};
		int m = arr.length;
		int n = 6;
		System.out.println(countWays(arr, m, n));
	}

}
