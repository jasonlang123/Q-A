import java.util.Scanner;
public class forLoopsNestedLoops {
	private Scanner input = new Scanner(System.in);
	//Letters A-Z
	public void AtoZ () {
		for(char letter = 'A'; letter<='Z'; letter ++ ) {
		System.out.println(letter);	
	}}
	
	public void guessNum() {
		//the answer is once because it's not 25 once you subract it.
		System.out.println ("how many times can you subtract the number 5 from 25?");
		for(int num = input.nextInt(); num != 1; num = input.nextInt()) {
		System.out.println ("how many times can you subtract the number 5 from 25?");
		num = input.nextInt();
	}
	}
	public void sumAllNums() {
		int answer = 0;
		System.out.println("give a number");
		int num = input.nextInt();
		for(int i = 0; i<=num; i++) {
		answer += i;
		}
		System.out.println(answer);
	}
public void prime() {
	System.out.println("give a number");
	int num = input.nextInt();
	
    for(int i=1; i <= num; i++){
            boolean isPrime = true;
            for(int j=2; j < i ; j++){
            	
            if(i % j == 0){
            isPrime = false;
            break;
                    }}
         if(isPrime)
            System.out.println(i);
    }
}
	
public void multiplicationTable(){
	int y;
	int x;
	for (y=1; y<=10; ++y)
	{
	    for (x=1; x<=12; ++x)
	    {
	        System.out.print(y*x+"  ");  
	    }
	    System.out.println();
	}    
	
}
	   
	
	

	public static void main(String[] args) {
		
		forLoopsNestedLoops runner = new forLoopsNestedLoops();
		runner.multiplicationTable();
		runner.prime();
		runner.sumAllNums();
		runner.guessNum();
		runner.AtoZ();
}}






	
	
