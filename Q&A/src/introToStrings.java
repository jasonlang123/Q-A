
public class introToStrings {

public void half(String str) {
	
	System.out.println(str.substring(str.length()/2));
}

public void concatenate (String str, String str2) {
	String word1 = (str.substring(1));
	String word2 = (str2.substring(1));
	String word3 = word1 + word2;
	System.out.println(word3);
}

public void adverb(String str) {
	String ly = "ly";
	String word = str.substring(str.length()-2);
	
	if (word.equals(ly)) {
		System.out.println("yes");
	}
	else
		System.out.println("no");
		
	}

public void backward (String str) {
	String backward = "";
	for (int i = str.length()-1; i != -1; i--) {
		backward += str.substring(i, i+1);
	}
	System.out.println(backward);
}


public static void main(String[]args) {
	introToStrings runner = new introToStrings();
	runner.half("hi there");
	runner.concatenate("hello", "there");
	runner.adverb("happily");
	runner.backward("hello");
}

}
