package kadaneAlgorithm;

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
		
		int lesser_Value = Integer.MAX_VALUE;
		int greater_value = 0;

		for (int i = 1; i < a.length; i++) {
			max_so_far = Math.max(0, max_so_far += a[i] - a[i - 1]);
			
//			if(max_so_far > maxSum){
				lesser_Value = Math.min(a[i - 1], lesser_Value);
				greater_value = Math.max(greater_value, a[i]);
//			}
			
			
			maxSum = Math.max(max_so_far, maxSum);
		}
		
		System.out.println(" Smaller value is " + lesser_Value + " and Greater value is " + greater_value);

		return maxSum;

	}

}
