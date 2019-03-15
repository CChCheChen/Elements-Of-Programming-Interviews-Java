package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.List;

/*
6.2 INCREMENT AN ARBITRARY-PRECISION INTEGER
Write a program which takes as input an array of digits encoding a decimal number D and updates the array to represent the number D + 1. 
For example, if the input is (1,2,9) then you should update the array to (1,3,0). 
Your algorithm should work even if it is implemented in a language that has finite-precision arithmetic.

Hint: Experiment with concrete examples.

P65(P78)

 */
public class Q_06_02_Increment_An_Arbitrary_Precision_Integer_as_List {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(9);
		input.add(9);
		input.add(9);
		input.add(9);
		
		System.out.println("Input is " + input);
		List<Integer> result = addOne(input);
		System.out.println("Add 1 is: " + result);
		
		System.out.println();

		System.out.println("Input is " + input);
		List<Integer> resultPlus = addOnePlus(input);
		System.out.println("Add 1 is: " + resultPlus);
	}

	/*Questions:
	 1. Do we need to consider negative numbers? such as "-100 + 1 = -99", assume we don't
	 2. Confirm what the input data type, array or list? assume we use List here
	 */


	//Time: O(n), n is the length of input array
	//Space: O(n) as well
	private static List<Integer> addOne(List<Integer> input) {

		List<Integer> copy = new ArrayList<>();
		copy.addAll(input);

		int size = copy.size();
		copy.set(size-1, input.get(size-1)+1);//last element of input is updated/replaced by (original value + 1)

		for(int i=size-1; i>0 && copy.get(i)==10; i--) {
			copy.set(i, 0);
			copy.set(i-1, copy.get(i-1)+1);
		}

		if(copy.get(0) == 10) {
			copy.set(0, 0);
			copy.add(0, 1);//add 1 at index0 ,shift all elements after to right
		}

		return copy;//this NOT modifies the original input
	}
	

	//Time: O(n), n is the length of input array
	//Space: O(1) no extra space required
	private static List<Integer> addOnePlus(List<Integer> input) {

		int size = input.size();
		input.set(size-1, input.get(size-1)+1);//last element of input is updated/replaced by (original value + 1)

		for(int i=size-1; i>0 && input.get(i)==10; i--) {
			input.set(i, 0);
			input.set(i-1, input.get(i-1)+1);
		}

		if(input.get(0) == 10) {
			input.set(0, 0);
			input.add(0, 1);//add 1 at index0 ,shift all elements after to right
		}

		return input;//this modifies the original input
	}

}
