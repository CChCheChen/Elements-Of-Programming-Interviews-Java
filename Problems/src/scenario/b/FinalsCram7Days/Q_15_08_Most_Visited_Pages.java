package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
15.8 THE MOST VISITED PAGES PROBLEM

You are given a server log file containing billions of lines. 
Each line contains a number of fields. 

For this problem, the relevant field is an id denoting the page that was accessed.

Write a function to read the next line from a log file, 
and a function to find the k most visited pages, where k is an input to the function. 

Optimize performance for the situation where calls to the two functions are interleaved. 

You can assume the set of distinct pages is small enough to fit in RAM.

As a concrete example, suppose the log file ids appear in the following order:
g,a,t,t,a,a,a,g,t,c,t,a,t, i.e., there are four pages with ids a(5),c(1),g(2),t(4) in total. 

After the first 10 lines have been read, 
the most common page is a with a count of 4, 
and the next most common page is t with a count of 3.

Hint: For each page, count of the number of times it has been visited.

P269(P282)

 */
public class Q_15_08_Most_Visited_Pages {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("g");
		list.add("a");
		list.add("t");
		list.add("t");
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("g");
		list.add("t");
		list.add("c");
		list.add("t");
		list.add("a");
		list.add("t");
		
		Map<String, Integer> map = new HashMap<>();
		int readCount = 10;
		for(int i=0; i<readCount; i++) {
			String s = list.get(i);
			if(map.containsKey(s))
				map.put(s, map.get(s)+1);
			else
				map.put(s, 1);
		}
		
		System.out.println("Before Sort: ");
		printMap(map);
		
		Map<String, Integer> mapSorted = sortMapByValue(map);
		
		System.out.println("After Sort: ");
		printMap(mapSorted);
		
		int k = 2;
		List<String> mostVisitedKPages = findMostVistedKPages(mapSorted, k);
		System.out.println("Most Visited " + k + " Pages: " + mostVisitedKPages);

	}

	//Time: O(logm), m is the distinct pages visited
	//Space:O(m), m is the distinct pages visited
	private static Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
//				System.out.println("o1.key=" + o1.getKey() + " --- o1.value=" + o1.getValue());
//				System.out.println("o2.key=" + o2.getKey() + " --- o2.value=" + o2.getValue());
				return (o2.getValue()).compareTo(o1.getValue());
			}
			
		});
		
//		for(int i=0; i<list.size(); i++) {
//			Entry<Character, Integer> e = list.get(i);
//			System.out.println("e.key=" + e.getKey() + " --- e.value=" + e.getValue());
//		}
		
		Map<String, Integer> mapSorted = new LinkedHashMap<>();;
		for(Entry<String, Integer> e : list) {
//			System.out.println("e.key=" + e.getKey() + " --- e.value=" + e.getValue());
			mapSorted.put(e.getKey(), e.getValue());
		}

		return mapSorted;
		
	}
	

	private static List<String> findMostVistedKPages(Map<String, Integer> map, int k) {
		if(null == map)
			return null;
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<k; i++) {
//			System.out.println("add " + (String)map.keySet().toArray()[i]);
			list.add((String)map.keySet().toArray()[i]);
		}
		return list;
	}
	
	private static void printMap(Map<String, Integer> map) {
		for(Entry<String, Integer> e : map.entrySet()) {
			System.out.println("Key-" + e.getKey() + " Value-" + e.getValue());
		}
	}
	
	

}
