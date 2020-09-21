
// Question and Answers mini-project by Jason
// Didn't need any help

public class FirstFile {
	
public static void main(String[] args) {
	
	System.out.println("How old are you?");
sleep(500);
System.out.println("I am 15 years old. I'll be turning 16 this November");
sleep(1000);
System.out.println("Where are you from?");
sleep(500);
System.out.println("I am from Southborough Massachusetts");
sleep(1000);
System.out.println("What sports are you doing at SM?");
sleep(500);
System.out.println("I will do Soccer, Rowing, and wrestling.");
sleep(1000);
System.out.println("What classes are you taking?");
sleep(500);
System.out.println("I am taking Algebra, Ceramics, Chinese, Computer Programming, Physics, and Survey of Literary Genres.");
sleep(1000);
System.out.println("What school did you go to before SM?");
sleep(500);
System.out.println("I attended the Fay School.");
}




public static void sleep(int time) {
	try {
		Thread.sleep(time);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

}
