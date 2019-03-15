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
public class Q_06_02_Increment_An_Arbitrary_Precision_Integer_as_Array {

	public static void main(String[] args) {
		int[] input = {9,9,9,7};
		int[] result = addOne(input);
		for(int i : input)
			System.out.print(i);
        System.out.print(" add 1 is:");
        for(int i : result)
        	System.out.print(i);
	}

	/*Questions:
	 1. Do we need to consider negative numbers? such as "-100 + 1 = -99", assume we don't
	 2. Confirm what the input data type, array or list? assume we use Array here
	 */
	
	//Time: O(n), n is the length of input array
	//Space: O(n) as well
	private static int[] addOne(int[] input) {
		List<Integer> list = new ArrayList<>();
		int overflow = 0;
		
		//last digit + 1
		int last = input[input.length-1] + 1;
		if(last < 10) {
			list.add(last);
		}else {
			list.add(0);
			overflow = 1;
		}
		
		for(int i=input.length-2; 0<=i; i--) {
			int temp = input[i] + overflow;
			if(temp < 10) {
				list.add(temp);
			}else {
				list.add(0);
				overflow = 1;
			}	
		}
		
		//Check if overflow still > 0 after going through all input elements
		System.out.println("overflow=" + overflow);
		if(overflow != 0) {
			list.add(overflow);
		}
		System.out.println("list:" + list);
		
		int size = list.size();
		int[] result = new int[size];
		for(int i=0; i<size; i++) {
			result[i] = list.get(size-1-i);
		}
		
		return result;
	}

}
