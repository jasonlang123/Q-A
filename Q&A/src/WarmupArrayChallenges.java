
public class WarmupArrayChallenges {

	public void addMultiply(double[]nums) {
		double sum = 0;
	for(int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * i;
			sum = sum + nums[i];
		}
	System.out.println(sum);
	}

public void combine(char[]letters) {
int count = 0;
String str = "";
	for(int i = 0; i < letters.length; i++) {
		if(letters[i]>='a' && letters[i]<='z') {
			str += letters[i];
		}
	}
	System.out.println(str);
}
public static void main(String[] args) {
	WarmupArrayChallenges runner = new WarmupArrayChallenges();
	runner.addMultiply(new double[] {5.8, 3.1, 2.5});
	runner.combine(new char[] {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?'});
}}

