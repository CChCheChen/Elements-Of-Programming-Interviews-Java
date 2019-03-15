package scenario.b.FinalsCram7Days;

import java.util.Random;

/*
6.11 SAMPLE OFFLINE DATA
This problem is motivated by the need for a company to select a random subset of its customers to roll out a new feature to. 

For example, a social networking company may want to see the effect of a new UI on page visit duration 
without taking the chance of alienating all its users if the roll-out is unsuccessful.

Implement an algorithm that takes as input an array of distinct elements and a size,
and returns a subset of the given size of the array elements. 
All subsets should be equally likely. 
Return the result in input array itself.

Hint: How would you construct a random subset of size k + 1 given a random subset of size k?

P78(P91)

 */
public class Q_06_11_Sample_Online_Data {

	public static void main(String[] args) {
		int[] input = {3,7,5,11,9,1};
		int size = 4;
		
		randomSumset(input, size);
		System.out.println("The randomly select subset is: ");
		for(int i=0; i<size; i++) {
			System.out.print(input[i] + " ");
		}
	}

	
	//Time: O(size)
	//Space:O(1)
	private static void randomSumset(int[] input, int size) {
		
		if(size >= input.length)
			return;
		
		Random random = new Random();
		
		for(int i=0; i<size; i++) {
			
			//Random.nextInt(RightBoundry) randomly returns a int from 0(included) to RightBoundry(excluded)
			//"input.length-i" makes sure the randomIndex will be in [0, input.length-i)
			//so i+randomIndex will be in [i, input.length) --> [i, input.length-1] 
			//which means the next element will be selected from [i, input.length-1]
			int randomIndex = random.nextInt(input.length-i);
			
			int temp = input[i];
			input[i] = input[i+randomIndex];
			input[i+randomIndex] = temp;
		}
		
		return;
	}

}
