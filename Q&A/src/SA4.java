
public class SA4 {

	


	// create your methods here
	public void distance(double x1, double y1, double x2, double y2) {
		
		System.out.println(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
		
	}
	
	public void quadratic(double a, double b, double c) {
		

		
		
		System.out.println((Math.sqrt((b*b)-4*a*c))/2*a);
		
		System.out.println(-1*(Math.sqrt((b*b)-4*a*c))/2*a);
	}
	
	public void charAverage(char one, char two) {
		
		int a;
		a=((one+two)/2);
		char c=(char)a;
		
		System.out.println(c);
		
		
		
	}
	
	public static void main(String[] args) {
		
		SA4 tester = new SA4();
		
		// prints out the distance between two points
		// output should be 6.83
		tester.distance(1, -2.5, 3.1, 4);
		
		// prints out a solution to y = ax^2 + bx + c, where the 
		// three parameters are a, b, and c. Use the quadratic equation
		// output should be 2 or -2 (challenge: give both solutions)
		tester.quadratic(1, 0, -4);
		
		// prints out the 'average' of two characters
		// output should be 'W'
		tester.charAverage('m', 'A');
	}

}
