package problemSolving1;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWaysGS2 {

	public static void main(String[] args) {
		System.out.println("Number of Ways are " + numDecodings("2724"));
	}

	public static long numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		if (!s.matches("[0-9]+")) {
			return 0;
		}

		int n = s.length();
		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;
		System.out.println(Arrays.toString(dp));
		for (int i = 2; i <= n; i++) {
			
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));
			
			System.out.print("I values is "+ i +"  First is" + first );
			System.out.println(" & Second is" + second + " String is " + s);
			if (first >= 1 && first <= 9) {
				dp[i] += dp[i - 1];
			}
			if (second >= 10 && second <= 26) {
				dp[i] += dp[i - 2];
			}
			
			System.out.println(Arrays.toString(dp));
		}
		return dp[n];
	}
}
