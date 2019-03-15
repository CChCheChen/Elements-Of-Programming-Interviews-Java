package scenario.b.FinalsCram7Days;


/*
7.6 REVERSE ALL THE WORDS IN A SENTENCE

Given a string containing a set of words separated by whitespace, 
we would like to transform it to a string in which the words appear in the reverse order. 

For example,
"Alice likes Bob" transforms to "Bob likes Alice". 

We do not need to keep the original string.

Implement a function for reversing the words in a string s.

Hint: It's difficult to solve this with one pass.

P101(P114)

 */
public class Q_07_06_Reverse_All_Words_In_Sentence {

	public static void main(String[] args) {
		
		String sentence = "Alice likes Bob";
		//String sentence = "ram is costly";
		//String sentence = "A man a plan a canal Panama";
		//String sentence = "Able was I ere I saw Elba";
		//String sentence = "Ray a Ray";

		System.out.println("'" + sentence + "' reverse all words: '" + reverseAllWords(sentence) +"'");
	}
	
    /*
    Questions:
    1. Do we need to consider punctuation? Assume there has no punctuation in sentence
     */
	
	//Time: O(s), s is the sentence word count
	//Space:O(n), n is the length of sentence
	private static String reverseAllWords(String sentence) {
		if(null == sentence || sentence.length()<=1)
			return sentence;
		
		StringBuilder sb = new StringBuilder();
		String[] strs = sentence.split(" ");
		
		for(int i=strs.length-1; i>=0; i--) {
			sb.append(strs[i]);
			if(i>0)
				sb.append(" ");
		}
		
		return sb.toString();
	}

}
