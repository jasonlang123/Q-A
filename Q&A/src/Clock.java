public class Clock {
	
	private int time;

	public void setTime(int x) {
	time=x; 
	}
	
	public void tick() {
		time=time+1;
	
	}
	
	
	public void displayTime(){
		
		System.out.println(time);
		
	}
	
	
	
	public static void main(String[] args) {
		Clock tester = new Clock();
		
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		
		
		
		
	}
}