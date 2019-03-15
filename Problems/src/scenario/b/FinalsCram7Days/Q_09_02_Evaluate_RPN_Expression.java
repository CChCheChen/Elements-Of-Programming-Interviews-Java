package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.List;

/*
9.2 EVALUATE RPN EXPRESSIONS

A string is said to be an arithmetical expression in Reverse Polish notation (RPN) if:

(1.) It is a single digit or a sequence of digits, prefixed with an option -, e.g., "6", "123", "-42".
(2.) It is of the form ¡°A,B,o" where A and B are RPN expressions and o is one of +,-,x,/

For example, the following strings satisfy these rules: 
"1729", 
"3, 4, +, 2, X, 1, +",
"1, 1, +, -2, x", 
"-641, 6, /, 28, /".

An RPN expression can be evaluated uniquely to an integer, which is determined recursively. 
The base case corresponds to 
Rule (1.) which is an integer expressed in base-10 positional system. 
Rule (2.) corresponds to the recursive case, and the RPNs are evaluated in the natural way, 
e.g., if A evaluates to 2 and B evaluates to 3, then "A,B,x" evaluates to 6.

Write a program that takes an arithmetical expression in RPN and returns the number that the expression evaluates to.
Hint: Process subexpressions, keeping values in a stack. How should operators be handled?

P135(P148)

 */
public class Q_09_02_Evaluate_RPN_Expression {

	public static void main(String[] args) {
		String input = "-641, 6, /, 28, /";
		Double result = evaluteRPNExpression(input);
		System.out.println("Result is " + result);
	}

	/*
	Questions:
	1. How the input String constructed? Each value-part is separated by "," or ", "? Assume it's ", ";
	 */
	
	//Time: O(n), n is the total number of characters in input
	//Space:O(n), worst is there has no operation, like "1729"
	private static Double evaluteRPNExpression(String input) {

		String separater = ", ";
		String[] strs = input.split(separater);
		
		List<Double> list = new ArrayList<>();//to hold numeric values from expression, or use Stack
		
		for(String val : strs) {
			//System.out.println("val=" + val);
			
			//make sure "X" and "x" will be recognized as "x"
			if(val.equalsIgnoreCase("x")) {
				val = val.toLowerCase();
			}
				
			if(val.length() == 1 && "+-xX/".contains(val)) {//Non-Numeric values
				
				//Get the value after operator  firstly
				Double second = list.remove(0); //System.out.println("second=" + second);
				//Get the value before operator secondly
				Double first = list.remove(0); //System.out.println("first=" + first);
				
				switch(val.charAt(0)) {
				case '+':
					list.add(0, (first+second));
					break;
				case '-':
					list.add(0, (first-second));
					break;
				case 'x':
					list.add(0, (first*second));
					break;
				case '/':
					list.add(0, (first/second));
					break;
				default:
					throw new IllegalArgumentException("Wrong RPN notation at " + val);
				}

			}else {//Numeric values
				list.add(0, Double.parseDouble(val));
			}
		}

		return list.get(0);
	}

}
