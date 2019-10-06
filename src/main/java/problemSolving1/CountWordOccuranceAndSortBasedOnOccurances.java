package problemSolving1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountWordOccuranceAndSortBasedOnOccurances {

	public static void main(String[] args) {
		String[] words = { "One", "Two", "Three", "Four", "One", "Two", "Three", "One", "Two" };

		int topWords = 2;
		List<Entry<String, Integer>> topWordsList = getTopWords(words);

		topWordsList.stream().limit(topWords).forEach(System.out::println);
	}

	private static List<Entry<String, Integer>> getTopWords(String[] words) {

		Map<String, Integer> countMap = new LinkedHashMap<String, Integer>();

		for (String word : words) {
			int count = 1;
			if (countMap.containsKey(word)) {
				count += countMap.get(word);
			}
			countMap.put(word, count);
		}

		List<Entry<String, Integer>> values = new ArrayList<>(countMap.entrySet());
		values.sort(new ValueComparator());

		return values;
	}
}

class ValueComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return -(o1.getValue().compareTo(o2.getValue()));
	}
}