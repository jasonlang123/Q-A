import java.util.Scanner;
public class startingWithArrays {

	public void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(" ");
		
	}
	
	public void oneToN(int n) {
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = i+1;
		}
		display(arr);
	}
	
	public void swap(int[] arr) {
		int first =  arr[0];
		int last = arr [arr.length-1];
		arr[0] = last;
		arr[arr.length-1] = first;
		display(arr);
	}
	
	private Scanner input = new Scanner(System.in);
	
	public void userArray() {
		int[] arr = new int[7];
		for(int i = 0; i < arr.length; i++) {
			System.out.println("give a number");
			int num = input.nextInt();
			arr[i] = num;
			}
		display(arr);
	}
	
	public void reverse(int arr[]) {
		int[] arr2 = new int[arr.length]; 
        int j = arr.length; 
        for (int i = 0; i < arr.length; i++) { 
            arr2[j - 1] = arr[i]; 
            j = j - 1; }
        display(arr2);
	}
	
		public static void main(String[] args) {
			startingWithArrays run = new startingWithArrays();
			run.reverse(new int[] {1, 2, 3, 4, 5});
			run.userArray();
			run.display(new int[] {3, 6, 8, 4});
			run.oneToN(5);
			run.swap(new int[] {1, 2, 3, 4});
			
}
}