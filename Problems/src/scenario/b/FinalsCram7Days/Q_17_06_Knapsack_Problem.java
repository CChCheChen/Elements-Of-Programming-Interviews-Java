package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
17.6 THE KNAPSACK PROBLEM

A thief breaks into a clock store. 
Each clock has a weight and a value, which are known to the thief. 
His knapsack cannot hold more than a specified combined weight. 
His intention is to take clocks whose total value is maximum subject to the knapsack's weight constraint.

If the knapsack can hold at most 130 ounces, he cannot take all the clocks. 
If he greedily chooses clocks, in decreasing order of value-to-weight ratio, he will choose P, H,O, B, I, and L in that order for a total value of $669. 
However, {H,J,O} is the optimum selection, yielding a total value of $695.

Write a program for the knapsack problem that selects a subset of items that has maximum value and satisfies the weight constraint. 
All items have integer weights and values. 

Return the value of the subset.

Hint: Greedy approaches are doomed.

P317(P330)

 */
public class Q_17_06_Knapsack_Problem {

	public static void main(String[] args) {
		List<Clock> list = new ArrayList<>();
		list.add(new Clock(65, 20));
		list.add(new Clock(35, 8));
		list.add(new Clock(245, 60));
		list.add(new Clock(195, 55));
		list.add(new Clock(65, 40));
		list.add(new Clock(150, 70));
		list.add(new Clock(275, 85));
		list.add(new Clock(155, 25));
		list.add(new Clock(120, 30));
		list.add(new Clock(320, 65));
		list.add(new Clock(75, 75));
		list.add(new Clock(40, 10));
		list.add(new Clock(200, 95));
		list.add(new Clock(100, 50));
		list.add(new Clock(220, 40));
		list.add(new Clock(99, 10));
		
		int weightConstraint = 130;
		
		int maxValue = maxValueToWeightConstraint(list, weightConstraint);
		
		System.out.println("The Max Value is $" + maxValue + " with Weight Constraint of " + weightConstraint + "oz.");

	}

	//Time: O(nw), n is clock amount and w is the weight constraint [0, weightConstraint]
	//Space:O(nw)
	private static int maxValueToWeightConstraint(List<Clock> list, int weightConstraint) {
		
		int[][] maxValues = new int[list.size()][weightConstraint+1]; //weightConstraint+1 is to include both 0 and weightConstraint
		for(int[] row : maxValues)
			Arrays.fill(row, -1);
		
//		for(int i=0; i<maxValues.length; i++) {
//			for(int j=0; j<maxValues[0].length; j++) {
//				System.out.print(maxValues[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int optimum = maxValueToWeightConstraintHelper(list, list.size()-1, weightConstraint, maxValues);
		
//		for(int i=0; i<maxValues.length; i++) {
//			for(int j=0; j<maxValues[0].length; j++) {
//				System.out.print(maxValues[i][j] + " ");
//			}
//			System.out.println();
//		}
			
		return optimum;
	}

	private static int maxValueToWeightConstraintHelper(List<Clock> list, int lastIndex, 
			                                            int weightConstraintCurr,
			                                            int[][] maxValues) {
		
		if(lastIndex < 0)
			return 0;
		
		if(maxValues[lastIndex][weightConstraintCurr] == -1) {
			
			int valWithoutCurr = maxValueToWeightConstraintHelper(list, lastIndex-1, weightConstraintCurr, maxValues);
			
			int valWithCurr = weightConstraintCurr < list.get(lastIndex).weight ? 
					          0 :
					          list.get(lastIndex).value + maxValueToWeightConstraintHelper(list, lastIndex-1, weightConstraintCurr-list.get(lastIndex).weight, maxValues);
				             
			
			maxValues[lastIndex][weightConstraintCurr] = Math.max(valWithoutCurr, valWithCurr);			
		}

		return maxValues[lastIndex][weightConstraintCurr];
	}

}

class Clock{
	public int value;
	public int weight;
	
	
	public Clock(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}
