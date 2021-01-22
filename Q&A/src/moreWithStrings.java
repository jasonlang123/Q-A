
public class moreWithStrings {

	public void same(String str) {
		
		String firstTwo = str.substring(0,2);
		String lastTwo = str.substring(str.length()-2);
		if (firstTwo.equals(lastTwo)) {
			System.out.println("yes");
		}
		else
			System.out.println("no");
	}
	
	public void numWords(String sentence) {
		
		int count = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' '){
				count++;
			}
		}
		System.out.println(count+1);
	}
	
	public void contained (String word, String letters) {
		int count = 0;
		for (int i = 0; i < letters.length(); i++) {
			count = 0;
			for (int j = 0; j < word.length(); j++) {
				if (letters.charAt(i) == word.charAt(j) && count != 1) {
					System.out.println("yes");
					count += 1;
				}
				else if (letters.charAt(i) != word.charAt(j) && j == word.length()-1 && count != 1) {
					System.out.println("no");
				}
			}
		}
	}
	
	//https://www.journaldev.com/18361/java-remove-character-string
	//Used this website for the .replace idea
	public void removeLetter(String str) {
		String strNew = str.replace("e", "");
		System.out.println(strNew);
	}
	
	public void palindrome (String str) {
		String backwards = "";
		for (int i = str.length()-1; i >= 0; i--) {
			backwards += str.charAt(i);
		}
		if (backwards.equals(str)) {
			System.out.println("palindrome");
		}
		else
			System.out.println("not a palindrome");
		
		
	}
	
	public static void main(String[]args) {
		moreWithStrings runner = new moreWithStrings();
		runner.same("edited");
		runner.numWords("hello there");
		runner.contained("Hello world", "leg");
		runner.removeLetter("let's eat there");
		runner.palindrome("kayak");
	}}

	