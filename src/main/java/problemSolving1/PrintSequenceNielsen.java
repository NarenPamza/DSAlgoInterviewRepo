package problemSolving1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PrintSequenceNielsen {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      System.out.println(generateSequence(Integer.parseInt(line)));
	    }
	    

	}

	private static int generateSequence(int n) {
		return findSequence(n,"0");
	}

	private static int findSequence(int n, String string) {
		
		if(string.length() >= n ){
			return Integer.parseInt(string.charAt(n) + "");
		}
		
		StringBuilder sequence = new StringBuilder();
		
		for (int i = 0; i < string.length(); i++) {
			
			if(Integer.parseInt(string.charAt(i) + "") == 0){
				sequence.append(1);
			}
			
			else if(Integer.parseInt(string.charAt(i) + "") ==1){
				sequence.append(2);
			}
			else if(Integer.parseInt(string.charAt(i)+ "") ==2){
				sequence.append(0);
			}
			
		}
		string = string + sequence;
		
		return findSequence(n,string);
		
	}

}
