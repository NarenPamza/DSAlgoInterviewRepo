package problemSolving1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class findReportingHierarchy {

	public static void main(String[] args) {
		
		Map<String, Set<String>> reportings = new LinkedHashMap();
		
		reportings.put("CEO", new HashSet<>(Arrays.asList(new String[]{"AVP"})));
		reportings.put("AVP", new HashSet<>(Arrays.asList(new String[]{"Manager"})));
		reportings.put("Manager", new HashSet<>(Arrays.asList(new String[]{"employee"})));
		reportings.put("employee", new HashSet<>(Arrays.asList(new String[]{""})));
		
		
		List<String> reverseOrderedKeys = new ArrayList<String>(reportings.keySet());
		Collections.reverse(reverseOrderedKeys);
		
		String key = "employee";
		
		for (String string : reverseOrderedKeys) {
			
			if(reportings.get(string).contains(key)){
				System.out.println(key + " is reporting to: " + string);
				key = string;
			}
			
		}

	}

}
