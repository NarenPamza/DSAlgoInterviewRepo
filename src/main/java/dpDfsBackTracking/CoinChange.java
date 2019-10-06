package dpDfsBackTracking;

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

	static long countWays(int coinArray[], int coinArrayLength, int n) {
		int dp[] = new int[n + 1];

		Arrays.fill(dp, 0);

		dp[0] = 1;

		for (int i = 0; i < coinArrayLength; i++) {

			System.out.println("Combination---start--");
			for (int j = coinArray[i]; j <= n; j++) {
//				System.out.println("J value is "+ j + " s[i] is " + S[i] + " j - S[i] is " + (j - S[i]) + " & a[j - S[i]] is " + a[j - S[i]] );
				dp[j] += dp[j - coinArray[i]];
//				System.out.println(Arrays.toString(a));
			}
			System.out.println(Arrays.toString(dp));
			System.out.println("Combination---End--");
		}
		return dp[n];
	}

	// Driver Function to test above function
	public static void main(String args[]) {
		int S[] = {  2, 5, 3, 6};
		int m = S.length;
		int n = 10;
		System.out.println(countWays(S, m, n));
	}

}
