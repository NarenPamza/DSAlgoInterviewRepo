package problemSolving1;

/**
 * 
 * @author Admin
 *
 */
public class PlotSaleRectanglePP {

	public static void main(String[] args) {
		int i = 12;
		System.out.println(findWays(i));
	}

	private static int findWays(int i) {
		boolean[] record = new boolean[i];
		int count = 0;
		int start = 1;
		for (int j = 0; j < i; j++) {
			if (!record[j]) {
				int modulo = i % start;
				int quotient = i / start;
				if (modulo == 0) {
					record[quotient - 1] = true;
					record[start - 1] = true;
					count = count + 1;
				}
			}
			start++;
		}
		return count;
	}

}
