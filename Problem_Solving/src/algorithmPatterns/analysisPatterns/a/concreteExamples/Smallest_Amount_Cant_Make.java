package algorithmPatterns.analysisPatterns.a.concreteExamples;

import java.util.Arrays;

/*
Write a program which takes an array of positive
integers and returns the smallest number which is not to the sum of a subset of
elements of the array.
 */
public class Smallest_Amount_Cant_Make {

	public static void main(String[] args) {
		int[] input = {1,1,5,1,1,1,10,25};
        System.out.println("Smallest Amount can't make by input is " + smallestAmount(input));
	}

	//Time: O(nlogn) --> O(nlogn) for sort, and O(n) for iterate
	private static int smallestAmount(int[] input) {
		if(null == input || input.length == 0)
			return 0;
		
		//sort the input first
		Arrays.sort(input);
		
		int result = 0;
		
		for(int i : input) {
			if(i > result+1) {
				result = result + 1;
				break;
			}
			result = result + i;
		}
		return result;
	}

}
