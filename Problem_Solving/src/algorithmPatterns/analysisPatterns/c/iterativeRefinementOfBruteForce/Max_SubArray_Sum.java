package algorithmPatterns.analysisPatterns.c.iterativeRefinementOfBruteForce;

/*
 * find the maximum sum over all subarrays of a given array of integer. Could have negative integers.
 */
public class Max_SubArray_Sum {

	public static void main(String[] args) {
		int[] input = {904,40,523,12,-335,-385,-124,481,-31};
        System.out.println("Max Sub-Array Sum of input is " + maxSubArraySum(input));

	}

	private static int maxSubArraySum(int[] input) {
		int maxSum = 0;
		int currentSum = 0;
		int minSum = 0;
		
		for(int i : input) {
			currentSum += i;
			
			if(currentSum < minSum) {//found a negative integer
				minSum = currentSum;
			}
			
			if(currentSum - minSum > maxSum) {
				maxSum = currentSum - minSum;
			}
		}
		
		return maxSum;
	}

}
