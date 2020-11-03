import java.util.Scanner;
public class whileLoops {



	
private Scanner input = new Scanner(System.in);
	public void numBetween(){

	

	System.out.println("What is your first number?");
	int num1 = input.nextInt();
	System.out.println("What is your second number?");
	int num2 = input.nextInt();
	int count = num1;
	//definite loop
	while(count <= num2) {
		System.out.println(count);
		count++;
			
		}
	
	}
	//definite loop
	public void ask4double() {
		
		System.out.println("Enter a base");
		double base = input.nextDouble();
		
		System.out.println("Enter a coefficient");
		double coe = input.nextDouble();
		
		int count = 0;
		while(count <=5) {
		System.out.println(coe * Math.pow(base, count));
		
		count ++;
		}
		
	}
	//definite loop
	public void squareRoot() {
		System.out.println("Enter a integer");
		int num1  = input.nextInt();
		int count = 0;
		while(count<num1) {
			if(count*count == num1) {
			System.out.println("The sqrt of "+num1+ "is " +count);
			break;
			}
			count++;
		}
		if(count == num1) {
			System.out.println("No sqrt");
		}
	}
	
	

	public static void main(String[] args) {
		whileLoops runner = new whileLoops();
		runner.numBetween();
		runner.ask4double();
		runner.squareRoot();
		
	}
	
}
