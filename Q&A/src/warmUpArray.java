import java.util.Arrays;

public class warmUpArray {

	public void average(double[] nums) {
		
		double sum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			sum+= nums[i];
		}
		System.out.println(sum/nums.length);
	}
	
	public void doubleValue(int[] nums) {
		int[] doubleValue = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			doubleValue[i] = nums[i]*2;
		}
		System.out.println(Arrays.toString(doubleValue));
	}
	
	public void words(String[] words) {
		for(int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
	}
	
	public void fibonacci(int n) {
		int [] fibonacci = new int [n];
		fibonacci[0] = 1; 
		fibonacci[1] = 1;
		for(int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}
		System.out.println(Arrays.toString(fibonacci));
	}
	
	public void divisible(double [] nums) {
		
		for(int i = 1; i < nums.length; i++) {
			if (nums[i] % nums[i - 1] == 0) {
				System.out.println("yes");
			}
			else
				System.out.println("no");
		}
	}
	
	public void oneToN(int n){
		int[] arr = new int[n]; 
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count++;
			arr[i] = count;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void duplicate(int [] nums1, int nums2[]) {
		for(int i = 0; i < nums1.length; i++) {
			for(int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j])
					System.out.println(nums1[i]);
			}}
		}
		
	public static void main(String[] args) {
		  warmUpArray runner = new warmUpArray();
		  runner.average(new double[] {1,2,3,4});
		  runner.doubleValue(new int[] {1,2,3,4});
		  runner.words(new String[] {"why", "hello", "there"});
		  runner.fibonacci(10);
		  runner.divisible(new double [] {8, 3, 12, 5, 15, 45});
		  runner.oneToN(6);
		  runner.duplicate(new int[] {8, 4, 9, 0, 2}, new int[] {7, 2, 3, 9, 6});
			  
		  
	}
}
