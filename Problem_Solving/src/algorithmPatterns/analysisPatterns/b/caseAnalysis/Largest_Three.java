package algorithmPatterns.analysisPatterns.b.caseAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Three {

	public static void main(String[] args) {
		int[] input = {24,16,3,6,23,10,21,9,2,22,25,4,8,17,19, 1,18,14,20,15,7,12,11,13,5};

        System.out.println("Largest 3 from input:  " + smallestAmount(input));

	}

	private static List<Integer> smallestAmount(int[] input) {
		List<Integer> result = new ArrayList<>();;
		
		int[] s1 = new int[5];
		int[] s2 = new int[5];
		int[] s3 = new int[5];
		int[] s4 = new int[5];
		int[] s5 = new int[5];

		splitArray(input, s1, s2, s3, s4, s5);
		
        s1 = sortFive(s1);
        s2 = sortFive(s2);
        s3 = sortFive(s3);
        s4 = sortFive(s4);
        s5 = sortFive(s5);
        printArray(s1);
        printArray(s2);
        printArray(s3);
        printArray(s4);
        printArray(s5);
        System.out.println("----------");
        
        int[] sMax1 = {s1[4],s2[4],s3[4],s4[4],s5[4]};
		sMax1 = sortFive(sMax1);
		result.add(sMax1[4]);
        
        
		orderArrays(sMax1, s1, s2, s3, s4, s5);
		printArray(s1);
		printArray(s2);
		printArray(s3);
		printArray(s4);
		printArray(s5);
		System.out.println("----------");
		
        int[] sMax23 = {s1[3],s2[4],s1[2],s2[3],s3[4]};
        sMax23 = sortFive(sMax23);
        result.add(sMax23[4]);
        result.add(sMax23[3]);

		return result;
	}
	
	private static void splitArray(int[] input, int[] s1, int[] s2, int[] s3, int[] s4, int[] s5) {

        int next = 0;
        
        next = helper(input, s1, next);
        next = helper(input, s2, next);
        next = helper(input, s3, next);
        next = helper(input, s4, next);
        next = helper(input, s5, next);
	}

	private static int helper(int[] input, int[] s, int next) {
		for(int i=0; i<5; i++) {
			s[i] = input[next];
			next++;
		}
		return next;
	}
	
	private static int[] sortFive(int[] s) {
		Arrays.sort(s);
		return s;
	}
	
	private static void orderArrays(int[] sMax1, int[] s1, int[] s2, int[] s3, int[] s4, int[] s5) {
		
		int[] s1Temp = null;
		int[] s2Temp = null;
		int[] s3Temp = null;
		int[] s4Temp = null;
		int[] s5Temp = null;

		System.out.println("s1Temp");
		s1Temp = orderArraysHelper(sMax1[4], s1, s2, s3, s4, s5).clone();
		printArray(s1Temp);
		System.out.println("s2Temp");
		s2Temp = orderArraysHelper(sMax1[3], s1, s2, s3, s4, s5).clone();
		printArray(s2Temp);
		System.out.println("s3Temp");
		s3Temp = orderArraysHelper(sMax1[2], s1, s2, s3, s4, s5).clone();
		printArray(s3Temp);
		System.out.println("s4Temp");
		s4Temp = orderArraysHelper(sMax1[1], s1, s2, s3, s4, s5).clone();
		printArray(s4Temp);
		System.out.println("s5Temp");
		s5Temp = orderArraysHelper(sMax1[0], s1, s2, s3, s4, s5).clone();
		printArray(s5Temp);
		System.out.println("----------");
		
		replaceElemenets(s1, s1Temp);
		replaceElemenets(s2, s2Temp);
		replaceElemenets(s3, s3Temp);
		replaceElemenets(s4, s4Temp);
		replaceElemenets(s5, s5Temp);
		
	}
	
	private static void replaceElemenets(int[] s, int[] sTemp) {
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i] + "-->" + sTemp[i]);
			s[i] = sTemp[i];
		}
		System.out.println();
	}

	private static int[] orderArraysHelper(int in, int[] s1, int[] s2, int[] s3, int[] s4, int[] s5) {
		int[] result = null;
		
		for(int i : s1) {
			if(i == in)
				result = s1;
		}
		
		for(int i : s2) {
			if(i == in)
				result = s2;
		}
		
		for(int i : s3) {
			if(i == in)
				result = s3;
		}
		
		for(int i : s4) {
			if(i == in)
				result = s4;
		}
		
		for(int i : s5) {
			if(i == in)
				result = s5;
		}

		return result;
	}
	
	private static void printArray(int[] s) {
		for(int i : s) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
