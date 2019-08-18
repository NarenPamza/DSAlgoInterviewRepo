package problemSolving1;

public class ShiftString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getShiftedString("abcd", 1, 2));

	}

	public static String getShiftedString(String s, int leftShifts, int rightShifts) {
		if(isStringOnlyAlphabet(s)){
			
			if(leftShifts>= 0)
			s = leftrotate(s, leftShifts);
			
			
			
			s = rightrotate(s, rightShifts);
			
		}
		return s;
	}
	
	public static boolean isStringOnlyAlphabet(String str) 
	{ 
	    return ((!str.equals("")) 
	            && (str != null) 
	            && (str.matches("^[a-z]*$"))); 
	} 

	static String leftrotate(String str, int d) {
		
		if(d>= 0 && d < str.length())
			str = str.substring(d) + str.substring(0, d);
		
		return str;
	}

	static String rightrotate(String str, int d) {
		if(d < str.length())
		return leftrotate(str, str.length() - d);
		
		return str;
	}

}
