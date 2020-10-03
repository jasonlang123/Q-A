
public class SimpleIfStatements {
//question 1
	public void positiveNegative(double x){
		if(x>0) 
		{
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		
	}
//question 2
	public void evenOdd(double x) {
		
		if(x%2 == 0) {
			
			System.out.println("even");
		}
		else {
			
			System.out.println("odd");
		}}
		
		
//question 3
		public void upperLower(char x) {
		if(x<91) {
			System.out.println("uppercase");
			
		}
		
		else if(x>=97){
			System.out.println("lowercase");
		}
		else {
			
			System.out.println("neither");
		}
		
		}
//question 4
		public void divideBy10(double x) {
			
			if(x%10==0) {
				System.out.println("divisible by 10");
			}
			else {
				System.out.println("not");
			}
		}
//question 5

		public void maximum(double x, double y, double z) {
			
			if (x > y) {
				if (x > z) {
					
					System.out.println(x);
				
				}
				
				else 
				{
					
					System.out.println(z);
				
				}
			}
			
			else {
				
				if (y > z) 
				{
					System.out.println(y);
				}
				else {
					System.out.println(z);
				}
			}
		}
	
	

	
public static void main(String[] args) {
	SimpleIfStatements tester = new SimpleIfStatements();
	tester.positiveNegative(5);
	tester.evenOdd(20);
	tester.upperLower('S');
	tester.divideBy10(19);
	tester.maximum(20,3,4);
}

}