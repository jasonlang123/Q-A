
public class LineSlope {
	
	// you'll probably want some instance variables... (4 coordinates and a slope)
double xOne;
double xTwo;
double yOne;
double yTwo;
double calculate_slope;

	// use the parameters to assign your instance variables
	public void set_coordinates (double x1, double y1, double x2, double y2) {
		
xOne = x1;
xTwo = x2;
yOne = y1;
yTwo = y2;
	}

	
	// calculate the slope using your instance variables
	public void calculate_slope () {
		
		// your code here
	
		calculate_slope = ((yTwo-yOne)/(xTwo-xOne));
	}

	
	// print the slope you calculated in calculate_slope
	public void display_slope () {
		
		// your code here
		System.out.println(calculate_slope);
	}
	
	public static void main(String[] args) {
		
		LineSlope runner = new LineSlope();
		
		// this line should have a slope of 2
		runner.set_coordinates(3, 3, 7, 11);
		runner.calculate_slope();
		runner.display_slope();
		
		// this line should have a slope of -.75
		runner.set_coordinates(0, -2, -4, 1);
		runner.calculate_slope();
		runner.display_slope();

	}
}