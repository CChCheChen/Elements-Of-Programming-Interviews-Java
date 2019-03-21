package scenario.b.FinalsCram7Days;

import java.util.HashSet;
import java.util.Set;

/*
18.7 COMPUTE THE MAXIMUM WATER TRAPPED BY A PAIR OF VERTICAL LINES

An array of integers naturally defines a set of lines parallel to the Y-axis, starting from x = 0. 
The goal of this problem is to find the pair of lines that together with the X-axis "trap" the most water. 

Write a program which takes as input an integer array and returns the pair of entries that trap the maximum amount of water.
Hint: Start with 0 and n ¡ª 1 and work your way in.

P345(P358)

 */
public class Q_18_07_Pair_Of_Walls_With_Maximum_Water_Trapped {

	public static void main(String[] args) {
		int[] input = {1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1};
		int[] output = findTwoWalls(input);
		
		System.out.println("The 2 walls trapped the maximum water is at " + output[0] + " and " + output[1]);
		System.out.println("The maximum water is " + (output[1] - output[0])*input[output[1]] + "m^3.");

	}

	//Time: O(n), n is the number of walls
	//Space:O(m), m is the distinct heights of walls
	private static int[] findTwoWalls(int[] input) {
		int[] output = new int[2];
		int leftIndex = 0;
		int rightIndex = input.length-1;
		
		int maxWater = 0;
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<input.length; i++) {
			if(!set.contains(input[i])) {
				set.add(input[i]);
				leftIndex = i;
				rightIndex = findSameRight(input, input[i]);
				
				if(input[i]*(rightIndex-leftIndex) > maxWater) {
					output[0] = leftIndex;
					output[1] = rightIndex;
				}
			}
		}

		return output;
	}

	private static int findSameRight(int[] input, int value) {
		int rightIndex = input.length-1;
		
		for(int i=input.length-1; i>=0; i--) {
			if(input[i] == value) {
				rightIndex = i;
				break;
			}
		}

		return rightIndex;
	}

}
