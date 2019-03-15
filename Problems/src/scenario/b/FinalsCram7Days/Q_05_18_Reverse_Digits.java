package scenario.b.FinalsCram7Days;

/*
5.8 REVERSE DIGITS 

Write a program which takes an integer and returns the integer corresponding to the digits of the input written in reverse order. 
For example, the reverse of 42 is 24, and the reverse of -314 is -413.

Hint: How would you solve the same problem if the input is presented as a string?

P54(P67)

 */
public class Q_05_18_Reverse_Digits {

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
		boolean negative = false;
		
		if(input < 0) {
			negative = true;
			input *= -1;
		}
		
		while(input>0) {
			System.out.println("Before: input=" + input + "; reverse=" + reverse);
			reverse = reverse*10 + input%10;
			input = input/10;
			System.out.println("After: input=" + input + "; reverse=" + reverse);
			System.out.println();
		}
		
		System.out.println("negative:" +negative);
		if(negative) 
			reverse *= -1;
		
		return reverse;
	}

}
