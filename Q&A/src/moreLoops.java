import java.util.Scanner;
public class moreLoops {

private int num2;

String answer;
private int num;
private int count = num;
private int product = 1;
	private Scanner input = new Scanner(System.in);
	public void negToPos(){
		int n;
		int y;
		System.out.println("give a positive number");
		n = input.nextInt();
		y = n*-1;
		
		
		while(y <=n) {

			System.out.println(y);
			y++;
				
			}}
	
	public void hi(){
		System.out.println("how many times do you wanna say hi?");
		num2 = input.nextInt();
		
		while(num2 > 0) {

			System.out.println("hi");
			num2--;
				
			}}
	
	
	public void guessNum() {
	int randomNum = 0;
		while(randomNum != 10) {
			System.out.println("guess the number");
			randomNum = input.nextInt();
		}
		System.out.println("you got it");
	}
	
	public void leastCommonMultiple(){
		System.out.print("give a number");
		int n1 = input.nextInt();
		System.out.print("give another number");
		int n2 = input.nextInt();
		int count = Math.max(n1, n2);
		
		while(count % n1 != 0 || count % n2 != 0) {
			count += 1;
			
			}
		System.out.println(count);
		}
		
	public void game() {
		boolean game = false;
		System.out.println("do you want to keep playing");
		answer = input.next();
		while(game == false){
		System.out.println("do you wan to keep playing");
		answer = input.next();
		if(answer.equals("no")){
			game = true;
		}
		}
		System.out.println("game over");
		}
	public void divisible() {
		int n = 1;
		System.out.println("give a number");
		int a = input.nextInt();
		while (n<a) {
			if(a%n == 0) {
				System.out.println(n);
			}
			n++;
		}
	}
		

	
		
public static void main(String[] args) {
	moreLoops runner = new moreLoops();
	runner.leastCommonMultiple();
	runner.game();
	runner.divisible();
	runner.guessNum();
	runner.negToPos();
	runner.hi();
	

	
	
}

}
