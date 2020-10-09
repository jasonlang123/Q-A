

public class HumanMethods {

	private int age;
	private char gender;

	public void set_age(int age_input) {
		age=age_input;
	
	}
	
	public void set_gender(char gender_input) {
		
		gender=gender_input;
		
	}
	
public void canYouVote() {
	if(age >= 18) {
		System.out.println("Can Vote");
	}
	else{
		System.out.println("Can't Vote");
	}
}


public void tetanusShot() {
	
	if((age % 4)==0) {
		System.out.println("Need a Tetanus Shot");
		
	}
	else {
		System.out.println("Don't Need a Tetanus Shot");
	}}
	
public void discount() {
	if(age>=65 || age<=12) {
		System.out.println("Discount");
		}
	else {
		System.out.println("No Discount");
	}}
	
public void todler() {
	if (gender == 'm' && age < 4) {
		System.out.println("Boy Todler");
	
	}
	
	else if (gender == 'f' && age < 4) {
		System.out.println("Girl Todler");
	}
	else {
		System.out.println("Not a Toddler");
	}
}


public void teenager() {
	if(age>=12 && age<=18) {
		System.out.println("Teenager");
	}
	else {
		System.out.println("Not a Teenager");
	}
}


public static void main(String[] args) {
	
		HumanMethods Jason = new HumanMethods();
		System.out.println("Jason:");
		Jason.set_age(15);
		Jason.set_gender('m');
		Jason.canYouVote();
		Jason.tetanusShot();
		Jason.todler();
		Jason.teenager();
		Jason.discount();
		
}}
		
	





	



