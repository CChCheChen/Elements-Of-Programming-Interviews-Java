package algorithmPatterns.algorithmDesignPatterns.f.invariants;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	public static void main(String[] args) {
		int[] input = {1,3,5,11,13,15,20,25};
		int sum = 36;
		
		int[] result1 = twoSum(input, sum);
		System.out.println("Solution1: Sum of " + sum + " in input are " + result1[0] + " and " + result1[1]);
		int[] result2 = twoSumPlus(input, sum);
		System.out.println("Solution2: Sum of " + sum + " in input are " + result2[0] + " and " + result2[1]);

	}

	private static int[] twoSum(int[] input, int sum) {
		int[] result = new int[2];
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i : input) {
			if(map.containsKey(sum-i)) {
				result[0] = sum-i;
				result[1] = map.get(sum-i);
			}else {
				map.put(i, sum-i);
			}
		}
		return result;
	}
	
	private static int[] twoSumPlus(int[] input, int sum) {
		int i = 0;
		int j = input.length-1;
		
		int[] result = new int[2];
		
		while(i < j) {
			if(input[i] + input[j] > sum) {
				j--;
			}else if(input[i] + input[j] < sum) {
				i++;
			}else {
				result[0] = input[i];
				result[1] = input[j];
				break;
			}
		}
		
		return result;
	}

}
