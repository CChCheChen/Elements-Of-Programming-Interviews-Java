package algorithmPatterns.analysisPatterns.d.reduction;

import java.util.Stack;

/*
 Consider the problem of determining if one string is a rotation of the other, 
 e.g., "car" and "arc" are rotations of each other
 */
public class String_Rotation_Check {

	public static void main(String[] args) {
		String s1 = "dcat";
		String s2 = "tacd";
		
		System.out.println("Strings '" + s1 + "' and '" + s2 + "' are rotations of each other? " + stringRotationCheck(s1, s2));

	}

	private static Boolean stringRotationCheck(String s1, String s2) {
		//check corner cases: 
		//1. both are null, need to clearify?
		//2. one is null
		//   --> they have different lengths
		if(s1.length() != s2.length())
			return false;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s2.length(); i++) {
			stack.push(s2.charAt(i));
		}
		
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) != stack.pop()) 
				return false;
		}
		
		return true;
	}

}
