package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.List;

/*
12.3 SEARCH A CYCLICALLY SORTED ARRAY

An array is said to be cyclically sorted if it is possible to cyclically shift its entries so that it becomes sorted. 

For example, the array in Figure 12.2 is cyclically sorted¡ªa cyclic left shift by 4 leads to a sorted array.
Design an O(log n) algorithm for finding the position of the smallest element in a cyclically sorted array. 
Assume all elements are distinct. 

For example, for the array in Figure 12.2 on the next page, your algorithm should return 4.
Hint: Use the divide and conquer principle.

378      478      550      631      103      203      220      234      279      368
A[0]     A[1]     A[2]     A[3]     A[4]      A[5]     A[6]     A[7]     A[8]     A[9]
Figure 12.2: A cyclically sorted array.

P192(P205)

 */
public class Q_12_03_Search_Cyclically_Sorted_Array {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(378);
		input.add(478);
		input.add(550);
		input.add(631);
		input.add(103);
		input.add(203);
		input.add(220);
		input.add(234);
		input.add(279);
		input.add(268);
		
		int smallestIndex = searchSmallest(input);
		
		System.out.println("Smallest Element at index of " + smallestIndex);
	}

	
	
	//When first see O(logn), the Binary Search comes to mind
	//Time: O(logn)
	//Space:O(1)
	private static int searchSmallest(List<Integer> input) {
		int left = 0;
		int right = input.size()-1;
		
		while(left < right) {
			int mid = left + (right-left)/2 + 1; System.out.println("mid=" + mid);
			
			if(input.get(left) > input.get(mid)) {//smallest in left half
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		return left;//left=right now
	}

}
