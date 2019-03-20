package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
16.3 GENERATE PERMUTATIONS
This problem is concerned with computing all permutations of an array. For example,
if the array is <2,3,5,7> 
one output could be:
<2,3,5,7>, <2,3,7,5>, <2,5,3,7>, <2,5,7,3>,
<2,7,3,5>, <2,7,5,3>, <3,2,5,7>, <3,2,7,5>, 
<3,5,2,7>, <3,5,7,2>, <3,7,2,5>, <3,7,5,2>,
<5,2,3,7>, <5,2,7,3>, <5,3,2,7>, <5,3,7,2>, 
<5,7,2,3>, <5,7,2,3>, <7,2,3,5>, <7,2,5,3>,
<7,3,2,5>, <7,3,5,2>, <7,5,2,3>, <7,5,3,2>. 
(Any other ordering is acceptable too.)

Write a program which takes as input an array of distinct integers and generates all permutations of that array. 
No permutation of the array may appear more than once.

Hint: How many possible values are there for the first element?

P287(P300)

 */
public class Q_16_03_Generate_Permutations {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(2);
		input.add(3);
		input.add(5);
		input.add(7);
		
		List<List<Integer>> permutations = generatePermutations(input);
		
		System.out.println("All permutations: ");
		for(List<Integer> list : permutations)
			System.out.println(list);

	}

	private static List<List<Integer>> generatePermutations(List<Integer> input) {
		List<List<Integer>> result = new ArrayList<>();
		generatePermutationsHelper(0, input, result);
		return result;
	}

	private static void generatePermutationsHelper(int startIndex, List<Integer> input, List<List<Integer>> result) {
		
		if(startIndex == input.size()-1) {
			result.add(new ArrayList<>(input));
			return;
		}
		
		for(int i=startIndex; i<input.size(); i++) {
			Collections.swap(input, startIndex, i);
			generatePermutationsHelper(startIndex+1, input, result);
			Collections.swap(input, startIndex, i);
		}
	}

}
