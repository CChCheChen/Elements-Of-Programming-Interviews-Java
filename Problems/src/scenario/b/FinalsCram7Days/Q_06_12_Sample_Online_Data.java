package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
6.12 SAMPLE ONLINE DATA

This problem is motivated by the design of a packet sniffer that provides a uniform sample of packets for a network session.

Design a program that takes as input a size k, and reads packets, continuously maintaining a uniform random subset of size k of the read packets.

Hint: Suppose you have a procedure which selects k packets from the first n > k packets as specified. How would you deal with the (n + l)th packet?

P79(P92)

 */
public class Q_06_12_Sample_Online_Data {

	public static void main(String[] args) {
		List<Character> list = new ArrayList<>();
		list.add('m');
		list.add('n');
		list.add('p');
		list.add('q');
		list.add('i');
		list.add('j');

		int k = 3;//uniform random subset size
		
		List<Character> subset = randomUnifromSubset(list, k);
		System.out.println("After all element in list is read, the uniform random subset is " + subset);

	}

	//Time: O(n), n is list size
	//Space:O(k), k is subset size
	private static List<Character> randomUnifromSubset(List<Character> list, int k) {
		
		if(k >= list.size())
			return list;
		
		Iterator<Character> itr = list.iterator();
		List<Character> subset = new ArrayList<>();
		
		//read the first k element from list
		for(int i=0; i<k && itr.hasNext(); i++) {
			subset.add(itr.next());
		}
		
		//1. start of the random selection from current_index to the list_end
        //2. swap with one of the element from subset
		int currentIndex = k;//index 0 to k-1 already read and added in subset
		Random random = new Random();
		
		while(itr.hasNext()) {
			currentIndex++;
			int randomIndex = random.nextInt(currentIndex);
			
			//System.out.print("Next=" + itr.next() + " ");
			//System.out.print("currentIndex=" + currentIndex + " ");
			//System.out.print("randomIndex=" + randomIndex + " ");
			//System.out.println();
			
			if(randomIndex < k) {
				subset.set(randomIndex, itr.next());//make sure swap only happen when randomIndex is in [0, k-1]
			}
		}

		return subset;
	}

}
