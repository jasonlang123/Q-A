
public class warmUpGroupStringWork {
	
	public void pigLatin(String str){
		String firstLetter = "";
		String pigLatin = "";
		firstLetter += str.substring(0,1);
		pigLatin += str.substring(1);
		pigLatin += firstLetter;
		pigLatin += "ay";
		System.out.println(pigLatin);
	}
	
	
	public void singleLetter(String str, char letter) {
		for(int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == letter) {
				System.out.println("$");
			}
			else
				System.out.println(str.charAt(i));
		}
	}
	
	public void longest(String [] arr) {
		String max = "";
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length() > max.length()) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		warmUpGroupStringWork runner = new warmUpGroupStringWork();
		runner.pigLatin("pig");
		runner.singleLetter("hello", 'l');
		runner.longest(new String[] {"hi", "hello", "bye"});
	}
}
