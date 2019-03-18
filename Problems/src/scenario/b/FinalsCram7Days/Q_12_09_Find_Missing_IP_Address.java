package scenario.b.FinalsCram7Days;

import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/*
12.9 FIND THE MISSING IP ADDRESS

The storage capacity of hard drives dwarfs that of RAM. 
This can lead to interesting space-time trade-offs.

Suppose you were given a file containing roughly one billion IP addresses, 
each of which is a 32-bit quantity. 

How would you programmatically find an IP address that is not in the file? 
Assume you have unlimited drive space but only a few megabytes of RAM at your disposal.

Hint: Can you be sure there is an address which is not in the file?

P202(P215)

 */

/*
 * IP address has the highest possible as 255.255.255.255
 * 255 = 2^8 -1
 * Each IP address has 32-bit
 * 
 * Initially I was thinking to 
 * check the Most Significant Bit by 1 and 0, to find if 1 or 0 has collection < 2^31
 * 
 * Focus on the collection < 2^31,
 * check the 2nd Most Significant Bit by 1 and 0, to find if 1 or 0 has collection < 2^30
 * 
 * Focus on the collection < 2^30,
 * check the 3rd Most Significant Bit by 1 and 0, to find if 1 or 0 has collection < 2^29
 * 
 * ... ... ...
 * 
 * After 32 passes of the file, we can find the missing IP address
 * with only 2 integer count variables in storage
 * 
 * -->
 * Since we have more storage
 * create an array of length 2^16 to store count of IP addresses beginning with 0,1,2,...,2^16-1 (all in xxxx xxxx xxxx xxxx format)
 * After 1 pass of the file, there should be 1 count < 2^16
 * 
 * Focus on the count less than 2^16
 * TODO:
 * 
 */
public class Q_12_09_Find_Missing_IP_Address {
	
	/*
	 * The  signed  left  shift operator "<<"  shifts a bit pattern to the left
	 * The  signed  right shift operator ">>"  shifts a bit pattern to the right.
	 * The unsigned right shift operator ">>>" shifts a zero into the leftmost position
	 */
	public static final int NUM = 1 << 16;

	public static int solution(List<Integer> file) {
		
		int ip = -1;
		
		int[] counts = new int[NUM];
		Iterator<Integer> itr = file.iterator();
		
		while(itr.hasNext()) {
			int index = itr.next() >>> 16;//shift each IP address to right by 16 bits: 1010 0101 1010 0101 1111 1111 1111 1111
	                                      //                                        -->1010 0101 1010 0101
	        counts[index]++;
		}
		
		for(int i=0; i<NUM; i++) {
			//look for the count < 2^16
			if(counts[i] < NUM) {
				BitSet bitSet = new BitSet(NUM);
				itr = file.iterator();
				
				while(itr.hasNext()) {
					int next = itr.next();//next is 32-bit
					
					if(i == (next >>> 16))//next is 16 bit now
						bitSet.set((NUM-1) & next); //NUM-1 = 1111 1111 1111 1111 1111 1111 1111 1111
					                                //"&" is AND
				}
				
				for(int j=0; j<NUM; j++) {
					if(!bitSet.get(j))
						ip = NUM | j; //"|" is OR
				}
				
			}
		}
		return ip;
	}

}
