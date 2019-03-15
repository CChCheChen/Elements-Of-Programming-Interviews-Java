package scenario.b.FinalsCram7Days;

/*
5.8 REVERSE DIGITS 
Write a program which takes an integer and returns the integer corresponding to the digits of the input written in reverse order. 
For example, the reverse of 42 is 24, and the reverse of -314 is -413.

Hint: How would you solve the same problem if the input is presented as a string?

P54(P67)

 */
public class Q_05_18_Reverse_Digits_with_Math_abs {

	public static void main(String[] args) {
		int input = -123;
		int reversed = reverseInt(input);
		System.out.println("Reverse " + input + " is " + reversed);
	}

	//Time: O(n), n is the digits number of input Integer
	private static int reverseInt(int input) {
		if(-10 < input && input <10) 
			return input;
		
		int reverse = 0;
		int inputRemain = Math.abs(input);
		
		while(inputRemain > 0) {
			reverse = reverse*10 + inputRemain%10;
			inputRemain /= 10;
		}
		
		return input<0 ? -reverse : reverse;
	}

}
