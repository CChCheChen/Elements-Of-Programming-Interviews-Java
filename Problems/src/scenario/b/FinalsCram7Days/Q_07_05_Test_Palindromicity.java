package scenario.b.FinalsCram7Days;


/*
7.5 TEST PALINDROMICITY

For the purpose of this problem, define a palindromic string to be a string which 
when the entire non-alphanumeric are removed it reads the same front to back ignoring case. 

For example, "A man, a plan, a canal, Panama." and "Able was I, ere I saw Elba!" are palindromic, but "Ray a Ray" is not.

Implement a function which takes as input a string s and returns true if s is a palindromic string.

Hint: Use two indices.

P100(P113)

 */
public class Q_07_05_Test_Palindromicity {

	public static void main(String[] args) {
		//String str = "A man, a plan, a canal, Panama.";
		String str = "Able was I, ere I saw Elba!";
		//String str = "Ray a Ray";
		
		System.out.println(str + " is palindromic? " + testPalindromicity(str));
	}

	//Time: O(n), n is str length
	//Space:O(1)
	private static boolean testPalindromicity(String str) {
		boolean result = true;
		
		int head = 0;
		int tail = str.length()-1;
		
		while(head < tail) {
			//move head pointer to the next letter or digit character
			while(!Character.isLetterOrDigit(str.charAt(head)) && head<tail) {
				head++;
			}
			//move tail pointer to the next letter or digit character
			while(!Character.isLetterOrDigit(str.charAt(tail)) && head<tail) {
				tail--;
			}
			
			System.out.println("head=" + head + " tail=" + tail);
			
			//check if head_character = tail_character
			if(Character.toLowerCase(str.charAt(head)) != Character.toLowerCase(str.charAt(tail))) {
				result = false;
				break;
			}
			
			head++;
			tail--;
				
		}
		return result;
	}

}
