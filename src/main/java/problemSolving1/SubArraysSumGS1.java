package problemSolving1;

// Java program to find number of subarrays 
// with sum exactly equal to k. 
/*
 * https://leetcode.com/problems/subarray-sum-equals-k/solution/
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArraysSumGS1 {

	static int findSubarraySum(List<Integer> arr, int sum) {
		HashMap<Integer, Integer> prevSum = new HashMap<>();

		int res = 0;

		// Sum of elements so far.
		Integer currsum = 0;

		for (Integer intValue : arr) {
			
			
			currsum = Integer.sum(res, intValue);

			if (currsum == sum)
				res++;

			if (prevSum.containsKey(currsum - sum))
				res += prevSum.get(currsum - sum);

			Integer count = prevSum.get(currsum);
			if (count == null)
				prevSum.put(currsum, 1);
			else
				prevSum.put(currsum, count + 1);
		}

		return res;
	}
	
	/*
	 * Best Approach covering all Scenarios
	 */
	public static int subarraySum(List<Integer> arr, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (Integer value : arr) {
            sum += value;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

	public static void main(String[] args) {

		List<Integer> al = new ArrayList<Integer>();
		al.add(6);
		al.add(2);
		al.add(4);
		al.add(1);
		al.add(5);
		
		int a[] = {6,2,4,1,5};
		System.out.println(subarraySum(al, 6));
	}
}
