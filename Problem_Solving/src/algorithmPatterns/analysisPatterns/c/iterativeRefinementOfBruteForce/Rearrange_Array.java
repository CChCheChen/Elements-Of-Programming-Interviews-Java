package algorithmPatterns.analysisPatterns.c.iterativeRefinementOfBruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rearrange_Array {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(24);
		list.add(16);
		list.add(3);
		list.add(6);
		list.add(23);
		list.add(10);
		list.add(21);
		list.add(9);

        System.out.println("Largest 3 from input:  " + rearrangeArray(list));

	}

	//B[0] <= B[l] => B[2] <= B[3] => B[4] <= B[5] => ...
	//Time: O(n)
	private static List<Integer> rearrangeArray(List<Integer> list) {
		
		for(int i=1; i<list.size(); i++) {
			if((i%2==0 && list.get(i-1)<list.get(i)) || (i%2!=0 && list.get(i-1)>list.get(i))) {
				Collections.swap(list, i-1, i);
			}
		}
		
		return list;
	}

}
