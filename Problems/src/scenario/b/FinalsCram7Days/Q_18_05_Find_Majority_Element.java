package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
18.5 FIND THE MAJORITY ELEMENT

Several applications require identification of elements in a sequence which occur more than a specified fraction of the total number of elements in the sequence. 
For example, we may want to identify the users using excessive network bandwidth or IP addresses originating the most Hypertext Transfer Protocol (HTTP) requests. 
Here we consider a simplified version of this problem.

You are reading a sequence of strings. 
You know a priori that more than half the strings are repetitions of a single string (the "majority element") but the positions where the majority element occurs are unknown. 

Write a program that makes a single pass over the sequence and identifies the majority element. 

For example, if the input is (b,a,c,a,a,b,a,a,c,a), then a is the majority element (it appears in 6 out of the 10 places).
Hint: Take advantage of the existence of a majority element to perform elimination.

P341(P354)

 */
public class Q_18_05_Find_Majority_Element {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("b");
		input.add("a");
		input.add("c");
		input.add("a");
		input.add("a");
		input.add("b");
		input.add("a");
		input.add("a");
		input.add("c");
		input.add("a");
		
		String major = findMajority(input);
		System.out.println("The Majority Element from input is " + major);
		
		String majorPlus = findMajorityPlus(input);
		System.out.println("The Majority Element from input is " + majorPlus);
	}
	
    //Time: O(n)
	//Space:O(n)
	private static String findMajority(List<String> input) {
		String major = "";
		
		Map<String, Integer> map = new HashMap<>();
		for(String s : input) {
			if(map.containsKey(s))
				map.put(s, map.get(s)+1);
			else
				map.put(s, 1);
		}
		
		int majorCount = 0;
		for(Entry<String, Integer> e : map.entrySet()) {
			if(e.getValue() > majorCount) {
				majorCount = e.getValue();
				major = e.getKey();
			}	
		}
		return major;
	}

	//Time: O(n)
	//Space:O(1)
	private static String findMajorityPlus(List<String> input) {
		String major = "";
		Iterator<String> itr = input.iterator();
		String next;
		int count = 0;
		
		while(itr.hasNext()) {
			next = itr.next();
			
			if(count == 0) {
				major = next;
				count++;
			}else if(major.equals(next)) {
				count++;
			}else {
				count--;
			}
		}
		return major;
	}

}
