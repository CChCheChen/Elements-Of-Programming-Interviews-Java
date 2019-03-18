package scenario.b.FinalsCram7Days;

import java.util.HashMap;
import java.util.Map;

/*
13.6 FIND THE NEAREST REPEATED ENTRIES IN AN ARRAY

People do not like reading text in which a word is used multiple times in a short paragraph. 
You are to write a program which helps identify such a problem.

Write a program which takes as input an array and finds the distance between a closest pair of equal entries. 
For example, 
if s = ("All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and", "no", "results"), 
then the second and third occurrences of "no" is the closest pair.

Hint: Each entry in the array is a candidate.

P218(P231)

 */
public class Q_13_06_Find_Nearest_Repeated_Entries_In_Array {

	public static void main(String[] args) {
		String[] input = {"All", "work", "and", "no", "play", "makes", "for", 
				          "no", "work", "fun", "and", "no", "no", "results"};
		
		int nearestDistance = findNearestRepeatedEntriesDistance(input);
		
		System.out.println("Input has the Nearest Repeated Entry with distance of " + nearestDistance);

	}

	//Time: O(n)
	//Space:O(s), s is the distinct Strings from input
	private static int findNearestRepeatedEntriesDistance(String[] input) {
		
		Map<String, Integer> map = new HashMap<>();
		int dis = Integer.MAX_VALUE;
		
		for(int i=0; i<input.length; i++) {
			
			if(map.containsKey(input[i])) {
				dis = Math.min(dis, i-map.get(input[i]));//update nearest distance by the minimum of
				                                         // current nearest distance and
				                                         // current index - previous index of the same String
			}
			
			map.put(input[i], i);//Store Distinct "String" with its "index"
		}
		return dis;
	}

}
