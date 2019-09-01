package problemSolving1;

/*
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWaysGS2 {

	public static void main(String[] args) {
		System.out.println(numDecodings("24176"));
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
		for (int i = 2; i <= n; i++) {
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));
			if (first >= 1 && first <= 9) {
				dp[i] += dp[i - 1];
			}
			if (second >= 10 && second <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}
}
