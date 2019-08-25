package problemSolving1;

// Java program to find first non-repeating character 

class StringNonRepeatingChar {
	static void firstNonRepeating(String str, int startIndex) {
		
		if (str.length() == 0) {
			System.out.println("No Repeating Characters in String");
			return;
		}

		String newString = str.replace(str.charAt(startIndex) + "", "");

		if (str.length() - newString.length() == 1) {
			
			System.out.println(str.charAt(startIndex));
			return;
		} else {
			firstNonRepeating(newString, 0);
		}
	}
	
	static int firstNonRepeatingApproach2(String str, int startIndex) {

		if (startIndex >= str.length()) {
			System.out.println("No Repeating Characters in String");
			return -1;
		}

		String newString = str.replace(str.charAt(startIndex) + "", "");

		if (str.length() - newString.length() == 1) {

			System.out.println(str.charAt(startIndex));
			return startIndex;
		} else {
			return firstNonRepeatingApproach2(str, startIndex + 1);
		}
	}
	
	static final int NO_OF_CHARS = 256; 
    static int count[] = new int[NO_OF_CHARS];
    
    public static int firstUniqChar(String s) {
        getCharCountArray(s); 
        int index = -1, i; 
       
        for (i = 0; i < s.length();  i++) 
        { 
            if (count[s.charAt(i)] == 1) 
            { 
                index = i; 
                break; 
            }    
        }   
        
      return index;
    }
    
    static void getCharCountArray(String str)  
     { 
         for (int i = 0; i < str.length();  i++) 
              count[str.charAt(i)]++; 
     }

    
    /*
     *  Best Approach
     */
	public static int firstUniqChar2(String s) {
		if (s == null || s.length() == 0)
			return -1;
		int result = Integer.MAX_VALUE;
		int fIndex = -1, lIndex = -1;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			fIndex = s.indexOf(ch);
			lIndex = s.lastIndexOf(ch);
			if (fIndex != -1 && fIndex == lIndex) {
				result = Integer.min(fIndex, result);
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}
	
	// Driver method
	public static void main (String[] args) 
	{ 
		String str = "acDca"; 
		firstNonRepeating(str, 0 ); 
		System.out.println("Index is " +firstNonRepeatingApproach2(str, 0));
		
		// Best Approach
		System.out.println(firstUniqChar2(str.toLowerCase()));
	}
}
