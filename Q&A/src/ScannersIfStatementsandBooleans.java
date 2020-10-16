//Jason's homework
//https://beginnersbook.com/2013/12/how-to-convert-string-to-double-in-java/ Used this website for one line of code
import java.util.Scanner;
public class ScannersIfStatementsandBooleans {
	private String num;
	private String num2;
	private double num3;
	private Scanner input = new Scanner(System.in);
	
	public void ask4num() {
		System.out.println("What's your number?");
		num = input.next();
		
		System.out.println("You're number is " + num + "");
		math();
	}
	
	
	public void math() {
		//Had to look this up. This turns the string into a double.
		System.out.println("type s to find the square root of your number. \ntype e to find out if it is even or odd.\n"
				+ "type d to find out if your number is a factor of another number\n"
				+ "type w to check if another number is within 3 of your number."
				+ "");
		double number = Double.parseDouble(num);
		
		String answer = input.next();	
		
		if (answer.equals("s")) {
			System.out.print(Math.sqrt(number));}
			
		else if (answer.equals("e")) {
				if(number%2==0) {
					System.out.println("even");
					ask4num();
				}
				else{ System.out.println("odd");
				ask4num();
			}}
				
			
		else if (answer.equals("d")) {
				System.out.println("type another number to check if it is a factor of the first.");
				num2 = input.next();
				double number2 = Double.parseDouble(num2);
				if(number %  number2==0 || number2 % number == 0) {
					System.out.println("factor");
					ask4num();
					}
					
				else {
					System.out.println("not a factor.");
					ask4num();
					}
				}
				
				
				else if (answer.equals("w")) {
					System.out.println("type another number to check if it is within 3 of the first");
					num2 = input.next();
					double number2 = Double.parseDouble(num2);
					if(number-number2 <=3 ||number-number2 >=-3) {
						System.out.println("within 3");
						ask4num();
					}
					else {
						System.out.println("not within 3");
						ask4num();
					}
					}
				else{
					System.out.println("Invalid Answer");
					ask4num();
					}
		}
					
					
				
				
			
			
	
	
	

	public static void main(String[] args) {
		
		
		ScannersIfStatementsandBooleans ScannersIfStatementsandBooleans = new ScannersIfStatementsandBooleans();
		ScannersIfStatementsandBooleans.ask4num();
	}
	}
