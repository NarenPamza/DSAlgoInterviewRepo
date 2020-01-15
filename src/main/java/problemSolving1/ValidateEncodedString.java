package problemSolving1;

import java.util.HashMap;
import java.util.Map;

/**
 * each char string will encoded as different random char.same inout char will
 * be encoded with same char. same encoded char should not repeat for other
 * input char.
 * 
 * @author Admin
 *
 */
public class ValidateEncodedString {

	public static void main(String[] args) {
		String message = "twitter";
		String encoded = "cucccfg";

		System.out.println(isValid(message, encoded));
	}

	private static boolean isValid(String message, String encoded) {

		if (message.length() != encoded.length()) {
			return false;
		}
		char[] inputArray = message.toCharArray();
		char[] encodedArray = encoded.toCharArray();

		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < message.length(); i++) {
			if (inputArray[i] == encodedArray[i]) {
				return false;
			}

			if (map.containsKey(encodedArray[i])) {

				if (map.get(encodedArray[i]) == inputArray[i]) {
					continue;
				} else {
					return false;
				}
			} else {
				map.put(encodedArray[i], inputArray[i]);
			}
		}

		return true;
	}

}
