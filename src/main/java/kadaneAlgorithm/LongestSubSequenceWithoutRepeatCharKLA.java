package kadaneAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubSequenceWithoutRepeatCharKLA {

	public static void main(String[] args) {

		String s = "abba";

		char[] charArray = s.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int max = 0;

		for (int i = 0, j = 0; i < charArray.length; i++) {

			if (map.containsKey(charArray[i])) {
				j = Math.max(j, map.get(charArray[i])+1);
			}
			map.put(charArray[i], i);
			max = Math.max(max, i - j + 1);

		}
		System.out.println(max);
		
		System.out.println(printCharWithoutRepeating(s));
	}
	
	//String s = "abcdefak";
	static int printCharWithoutRepeating(String s) {
		int max = 0;
		char[] charArray = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0, j = 0; i < charArray.length; i++) {
			
			if(map.containsKey(charArray[i])){
				j = map.get(charArray[i]) +1;
			}
			
			map.put(charArray[i], i);
			max = Math.max(max, i - j +1);
		}

		return max;
	}

}
