package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/*
11.3 SORT AN ALMOST-SORTED ARRAY

Often data is almost-sorted¡ªfor 
example, a server receives time-stamped stock quotes and earlier quotes may arrive slightly after later quotes 
because of differences in server loads and network routes. 

In this problem we address efficient ways to sort such data.

Write a program which takes as input a very long sequence of numbers and *prints* the numbers in sorted order. 
Each number is at most k away from its correctly sorted position. 
(Such an array is sometimes referred to as being 
For example, no number in the sequence (3,-1,2,6,4,5,8} is more than 2 away from its final sorted position.

Hint: How many numbers

P180(P193)

 */
public class Q_11_03_Sort_AlmostSorted_Array {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();
		input.add(3);
		input.add(-1);
		input.add(2);
		input.add(6);
		input.add(4);
		input.add(5);
		input.add(8);
		
        Iterator<Integer> itr = input.iterator();
        int k = 2;//max distance to final sorted position

        System.out.println("After sorting, input becomes ");
        sortAlmostSortedData(itr, k);
	}

	//This question ONLY prints the elements in sorted order, not modifying input in place
	//Time :O(nlogk)
	//Space:O(k)
	private static void sortAlmostSortedData(Iterator<Integer> itr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();//minHeap is smallest on top
		
		//Add the first k elements into minHeap from input list
		for(int i=0; i<k && itr.hasNext(); i++) {
			minHeap.add(itr.next());
		}
		
		//for (k+1)th element and after, retrieve/remove and print the smallest in minHeap.
		//then add next element to minHeap
		while(itr.hasNext()) {
			int smallest = minHeap.remove();
			System.out.print(" " + smallest);
			minHeap.add(itr.next());
		}
		
		//After all element are iterated, still have k elements in minHeap not yet printed
		//retrieve/remove and print smallest one by one in minHeap
		while(!minHeap.isEmpty()) {
			int smallest = minHeap.remove();
			System.out.print(" " + smallest);
		}
		
	}

}
