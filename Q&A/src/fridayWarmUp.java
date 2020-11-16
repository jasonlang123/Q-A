
public class fridayWarmUp {
	
//Take a number x as parameter. 
//Print out the digits of this number, one by one (one's digit first, then ten's digit, and so on).
//For example, if x = 285, we would print: 5, 8, 2
	
	public void digits(int n) {
		while(n > 0) {
			System.out.println(n%10);
			n=n/10;
	}
		}
	public void rectangle(int x, int y) {
		for(int i = 0; i < y; i++) {
			
			for(int j = 0; j < x; j++) {
				
				System.out.print("X");
			}
			System.out.println();
		}
		
	}

	public void singleFactors(int n) {
		for(int i = 1; i<=n; i++) {
			if(n % i == 0) {
				System.out.println(i);
			}
		}
	}
	
	public void factors(int n) {
		for (int i = 1; i <= n; i++) {
			singleFactors(i);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		fridayWarmUp runner = new fridayWarmUp();
		runner.digits(285);	
		runner.rectangle(3, 2);
		runner.factors(8);
	}
		}

