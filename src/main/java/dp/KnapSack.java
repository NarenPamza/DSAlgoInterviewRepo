package dp;

public class KnapSack {

	public static void main(String[] args) {

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));

	}

	private static int knapSack(int WtValue, int[] wt, int[] val, int n) {

		int K[][] = new int[n + 1][WtValue + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= WtValue; w++) {
				if (i == 0 || w == 0) {
					K[i][w] = 0;
				} else if (wt[i - 1] <= w) {
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
			}
			// System.out.println(" ");
		}

		return K[n][WtValue];
	}

}
