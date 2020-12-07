
public class moreArrayPractice {
	
	public void integer(int num) {
		int[] arr = new int[(int)(Math.log10(num)+1)];
		for(int i = arr.length-1; i >= 0; i--) {
			
			arr[i] = ((num%10));
	
			num = num/10;
			
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		
		System.out.println("");
	}
	
	
	public void common(int[]arr, int []arr2) {
	for (int i = 0; i < arr.length; i++)
    {
        for (int j = 0; j < arr2.length; j++)
        {
            if(arr[i] == (arr2[j]))
            {
             
             System.out.print((arr[i]+","));
             }}}}
	
	//Create a method that takes an array of doubles as parameter. 
	//It should print the average of all the numbers in the array. 
	//Make sure it's the exact average (beware integers!)
	
	
	public void average(int[] arr) {
		
		double sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum/arr.length);
	}
	
//	Create a method that takes an array of integers as parameter. 
	//The method should create a new String array of the same size. 
	//The elements of the String array should be "pos" if the corresponding number of the other array is positive, 
	//and "negative" otherwise. Display this string array.
   // example: [-4,6,2,-1,-6,9]    would give     ["neg","pos","pos","neg","neg","pos"]
	public void posNeg(int[] arr) {
		String[] arr2 = new String[arr.length]; 
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) {
				arr2[i] = "neg";
			}
			else {
				arr2[i] = "pos";
			}
			System.out.println(arr2[i]);
		}
		
	}
	
	//Create a method that takes two integer arrays as parameters. 
	//Your method should merge these two arrays into one. Display this new array.
	
	public void merge(int[] arr, int[] arr2) {
		int[] merge = new int[arr.length + arr2.length]; 
		int count = 0;
		for(int i = 0; i < arr.length; i++) { 
	         merge[i] = arr[i];
	         count++;
	      } 
	      for(int j = 0; j < arr2.length;j++) { 
	         merge[count++] = arr2[j];
	      } 
	      for(int i = 0;i < merge.length;i++) {
	    	  System.out.println(merge[i]);
	      }
	}
	
	public void search (char cha, char[] arr) {
		
		boolean found = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == cha) {
				found = true;
			}
		}
		if(found)
			System.out.println("contains");
		else
			System.out.println("does not contain");
	}
	
	
	public static void main(String[] args) {
		moreArrayPractice run = new moreArrayPractice();
		run.integer(39564);
		run.search('b', new char[] {'i','g','o','c'});
		run.merge(new int[] {4,1,3}, new int[] {8,3,5,6});
		run.posNeg(new int[] {-4,6,2,-1,-6,9});
		run.average(new int[] {2,3,1,7});
		run.common(new int[] {4,1,3}, new int[] {8,3,5,4});
	}

}

