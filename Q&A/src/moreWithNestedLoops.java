import java.util.Scanner;
public class moreWithNestedLoops {
	private Scanner input = new Scanner(System.in);
	public void loop(int n) {
		
		for (int i = 1; i <= n; i++) {
			for(int j = i; j<=n+i; j++) {
				System.out.print(j<= 5 ? j: j-5);
			
		}
			System.out.println();
		}}
	
	public void triangle() {
		System.out.println("give a number");
		int n = input.nextInt();
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j < i; j ++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void what_power() {
		System.out.println("give a number");
		int x = input.nextInt();
		System.out.println("give another number");
		int y = input.nextInt();
		
		
		for (int exponent = 1; exponent <= y; exponent++) {
				if(Math.pow(x, exponent) == y) {
					System.out.println(exponent);
						
					}
				}
			}
		
		
	    
	
	
	
	
	public static void main(String[] args) {
		moreWithNestedLoops runner = new moreWithNestedLoops();
		runner.what_power();
		runner.loop(5);
		runner.triangle();

	}}
