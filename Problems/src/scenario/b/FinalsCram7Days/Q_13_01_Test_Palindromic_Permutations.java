package scenario.b.FinalsCram7Days;

import java.util.HashMap;
import java.util.Map;

/*
13.1 TEST FOR PALINDROMIC PERMUTATIONS

A palindrome is a string that reads the same forwards and backwards, e.g., "level", "rotator", and "foobaraboof".

Write a program to test whether the letters forming a string can be permuted to form a palindrome. 
For example, "edified" can be permuted to form "deified".

Hint: Find a simple characterization of strings that can be permuted to form a palindrome.

P212(P225)

 */
public class Q_13_01_Test_Palindromic_Permutations {

	public static void main(String[] args) {
		String input = "edified";
		
		boolean palindromicPermutation = testPalindromicPermutation(input);
		
		System.out.println(input + " has Palindormic Permutation? " + palindromicPermutation);

	}

	//Time: O(n)
	//SPace:O(c), c is input distinct Character count
	private static boolean testPalindromicPermutation(String input) {
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			}else {
				map.put(c, 1);
			}
		}
		
		//make sure character counts in map, having maximum ONLY 1 odd value
		int oddCount = 0;
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			if(e.getValue()%2 != 0)
				oddCount++;
			
			if(oddCount > 1)
				return false;
		}
		
		
		return true;
	}

}
