//Jason's Prison Escape

import java.util.Scanner;

public class Adventure {
//This variable stores which getaway driver the player picked so the code will know what choice you made later on
private int getawayDriver;
//This variable is used to store the players name so it can be used later on
private String yourName;
//This variable is used to store which escape option the player picked so the code will know
private int escape_option;

private Scanner input = new Scanner(System.in);

//The introduction just asks for you name and gives some background information
public void intro() {

System.out.print("Hello, what's your name? ");
yourName = input.next();
System.out.println("You're " + yourName + " you have been unfairly sentenced to prison for life for a murder that you had nothing to do with. \n"
		+ "Today is the day you decided that you've had enough of being locked behind bars and you're going to attempt to escape.\n");
				 
getaway_driver();

}
//During this part you choose the getaway driver for the escape. The variable above is used to store which choice you made
public void getaway_driver() {
	System.out.print("First, you must choose your getaway driver.");
	System.out.println("\nJeff is the fastest getaway driver. However, he is a risky choice because he is not the best driver.");
	System.out.println("Elly is the slowest of the three. However, she is very good at driving and it is highly unlikely for her to crash.");
	System.out.println("Robert is probably your best choice. He's decent at driving and drives at a pretty good speed.");
	System.out.println("\n a. Jeff \n b. Elly \n c. Robert");
	
	String answer = input.next();
	
	
	if (answer.equals("a")) {
	getawayDriver = 1;
		escape_plan();}
	
	else if (answer.equals("b")) {
		getawayDriver = 2;
		escape_plan();
	}
		
	
	else if (answer.equals("c")) {
		getawayDriver = 3;
		escape_plan();
		}
	
//This code right here just tells the player whatever they typed is invalid if for some reason they type something random
	else {
		System.out.println("Invalid Answer");
		getaway_driver();
	}
		
	
	
}
//Right here you pick which escape plan you'd like to do
//The variable escape_option changes to 1,2, or 3 depending on what you pick. This will be used later on
public void escape_plan(){
System.out.print("Now, you must plan your escape.");
	
	System.out.println("\n a. Dig a tunnel \n b. Break the window \n c. Get a disguise");
	
	String answer = input.next();
	

	if (answer.equals("a")) {
		escape_option = 1;
		
		tunnel();
		
		}
	
	else if (answer.equals("b")) {
		escape_option = 2;
	
		window_escape();
		
		}
	
	else if (answer.equals("c")) {
		escape_option = 3;
	
		disguise();
			
		}
	
	
	else {
		System.out.println("Invalid Answer");
		escape_plan();
	}
	
}
	
	


//If you picked the tunnel escape, it brings you here. You get to pick which tool you'd like to dig the tunnel with.
public void tunnel() {
	System.out.print("What tool would you like to use to dig the tunnel?");
	
	System.out.println("\n a. Spoon \n b. Drill");
	
	String answer = input.next();
	
	if (answer.equals("a")) 
		tunnel_escape_spoon();
	else if(answer.equals("b"))
		tunnel_escape_drill();
	
	else {
		System.out.println("Invalid Answer");
		tunnel();
	}
}
//If you pick the window escape you get sent here
public void window_escape() {
	
	System.out.print("The metal bar window in your cell is very rusty and looks like it could easily be ripped off with some type of tool. \n"
			+ "It would probably be a good idea to talk to Dan who lives in the cell across from you.\n"
			+ "Dan is known throughout the entire prison for having lots of contraband.");
	System.out.println("You go talk to Dan and find out that he has a crowbar. \nHe tells you that he will give it to you in exchange for a favor."
			+ "Dan wants you to find a man named Johnathan who owes him money. \nHe describes him as having brown hair, blue eyes, and being roughly 5 feet, 9 inches tall.");
	look_for_johnathan();
}
//You go look for Johnathan and you are given a few options of where to look for him
public void look_for_johnathan() {
	System.out.println("\nWhere would you like to look?");
	
	
	System.out.println("\n a. Cafeteria \n b. Gym \n c. Library \n d. Courtyard \n e. Return to Dan");
	String answer = input.next();
	if (answer.equals("a")) 
		cafeteria();
	else if(answer.equals("b"))
		gym();
	else if(answer.equals("c"))
		library();
	else if(answer.equals("d"))
		courtyard();
	else if (answer.equals("e"))
		return2dan();
	else {
		System.out.println("Invalid Answer");
		look_for_johnathan();
	}
}
//These next few lines of code are used for when you look for Johnathan the correct one is the library
public void cafeteria(){
	System.out.println("You check the cafeteria and find no one that fits the description.");
	look_for_johnathan();
}

public void gym() {
	System.out.println("You check the gym and find no one that fits the description.");
	look_for_johnathan();
}
public void library() {
	System.out.println("You check the library and find someone that looks similar to the discription you were given. \nYou should probably go talk to Dan");
	look_for_johnathan();
}

public void courtyard() {
	System.out.println("You check the courtyard and find no one that fits the description.");
	look_for_johnathan();
}
//If you give the correct location you win! Otherwise you'll lose and have to try again
public void return2dan() {
	System.out.println("Dan asks you if you found Johnathan. What do you say?");
	System.out.println("\n a. Cafeteria \n b. Gym \n c. Library \n d. Courtyard \n e. Go look again");
	String answer = input.next();
	if (answer.equals("a")) 
		crowbar_fail();
	else if(answer.equals("b"))
		crowbar_fail();
	else if(answer.equals("c"))
		crowbar_success();
	else if(answer.equals("d"))
		crowbar_fail();
	else if (answer.equals("d"))
		look_for_johnathan();
		else {
			System.out.println("Invalid Answer");
			return2dan();
		}
	
}
//If you give the wrong answer dan will beat you up :(
public void crowbar_fail() {
	System.out.println("Dan gives you the crowbar but you later get beat up by him and his friends for giving him the wrong information.");
	System.out.println("Type a to try again");
	String answer = input.next();
	if (answer.equals("a")) 
		return2dan();
		else {
			System.out.println("Invalid Answer");
			crowbar_fail();
		}
}
//If you give him the right answer you can use the crowbar to break the window and escape
public void crowbar_success() {
	System.out.println("Dan gives you the crowbar and leaves to go look for Johnathan. You can now use the crowbar to open your cell window.\n"
			+ "You make sure no guards are around and then use the crowbar to rip off the metal bar window. \n"
			+ "You can barely squeeze through the window and jump out. Your cell is 3 stories high. What would you like to do?");
	System.out.println("\n a. Jump out the window. \n b. Steal a bunch of pillows and throw them out the window to break your fall \n c. Steal a bunch of bed sheets and tie them together to make a rope");
	String answer = input.next();
	if (answer.equals("a")) 
		window_fail();
	
	else if(answer.equals("b"))
		window_success1();
	else if (answer.equals("c"))
		window_success2();
		else {
			System.out.println("Invalid Answer");
			crowbar_success();
		}
}
//If you jump out the window with nothing to break your fall you lose
public void window_fail() {
	System.out.println("You jumped out the window and broke both your legs. Probably not the smartest move.");
	System.out.println("Type a to try again");
	String answer = input.next();
	if (answer.equals("a")) 
		crowbar_success();
	else {
		System.out.println("Invalid Answer");
		window_fail();
	}
}
//If you use the pillows to break your fall you'll succcessfully escape
public void window_success1(){
	System.out.println("You jumped out the window and landed on the pillows. You have successfully escaped.");
	getaway();
}
//If you use the bed sheets to make a rope that works too
public void window_success2(){
	System.out.println("You slid down the bed sheet rope and successfully escaped.");
	getaway();
}
//If you pick the disguise option, it brings you here
public void disguise() {
	System.out.println("Your plan is to dress up like a guard and escape the prison using this disguise. \n"
			+ "You know that the guard uniforms are in the equipment room.");
	System.out.println ("You also know that the door to the equipment room has a keycode and if it is typed incorrectly, it will set off an alarm. \nYou've heard rumors that the combination can be found inside the prison office.");
	System.out.println("\nWhat would you like to do?");
	System.out.println("\n a. Break into the office \n b. Guess the password");
	
	String answer = input.next();
	
	if (answer.equals("a")) 
		office_breakin();
	
	else if(answer.equals("b"))
		equipment_room_door();
	
	else {
		System.out.println("Invalid Answer");
		disguise();
	}
}
//You can break into the office to get the code
public void office_breakin() {
System.out.println("You walk over to the office door. You notice that you could probably easily break open the door. \nYou also notice a vent with missing screws that could easily be pulled off the side of the wall.");
	System.out.println("What would you like to do?");
	System.out.println("\n a. Break open the door \n b. Crawl through the vent.");
	String answer = input.next();
	if (answer.equals("a")) 
		office_fail();
	
	else if(answer.equals("b"))
		vent();
	
	else  {
			System.out.println("Invalid Answer");
			office_breakin();
		}
	
}
//If you break the door this will be very loud and you will get caught
public void office_fail() {
	System.out.println("You run full speed into the door and break it open. \nThis probably was not the smartest idea because it was very loud and attracted a bunch of guards."
			+ " Type a to try again.");
	String answer = input.next();
	if (answer.equals("a")) 
		office_breakin();
	
	else {
		System.out.println("Invalid Answer");
		office_fail();
	}
	
	}
//The vent is the correct way to break into the office
public void vent(){
	System.out.print("You climb into the vent and crawl to another vent which leads into the office. \nYou peak through the cracks of the vent into the office to make sure no one is in there. ");
	System.out.print("\nOnce you make sure the coast is clear, you kick open the vent and jump out into the office. \nNow it's time to find that code.");
	office();
	
}
//The player is given multiple options of what they can search
//The correct spot is under the desk
public void office() {
	System.out.println("\nWhere would you like to check?");
	System.out.println("\n a. Search the drawer \n b. Search through the laptop left open on the desk \n c. Search the file cabinet \n d. Look under the desk \n e. Exit the office");
	String answer = input.next();
	if (answer.equals("a")) 
		drawer();
	
	else if(answer.equals("b"))
		laptop();
	
	else if(answer.equals("c"))
		file_cabinet();
	
	else if(answer.equals("d"))
		under_desk();
	
	else if(answer.equals("e"))
	exit_office();
	else {
		System.out.println("Invalid Answer");
		office();
	}
}
	

//Once again these are the places you can look for the code
//The code is 3572
//This code searches the drawer
public void drawer() {
	System.out.println("You search inside the drawer and don't find the code.");
	office();
}
//This code searches the laptop
public void laptop() {
	System.out.println("You browse through the laptop and don't find the code.");
	office();
}
//This code searches the file cabinet
public void file_cabinet() {
	System.out.println("You search inside the file cabinet and don't find the code.");
	office();
}
//This code searches under the desk which is the correct spot
public void under_desk() {
	System.out.println("You look under the desk and find a yellow sticky note. It has the numbers 3572 written on it.");
	office();
}
//If you want to guess the code or you're like me and already know it you are brought here
//You are also brought here after you leave the office
public void equipment_room_door() {
	
	System.out.println("You walk over to the equipment room door. There are no guards around so now is your chance to quickly input the password.");
	System.out.println("Type in the password");
	String answer = input.next();
	//This checks to make sure you put in the right numbers
	//Anything else results in you losing
	if (answer.equals("3572")) 
		equipment_room();
	
	
	else 
		equipment_room_fail();
}
//If you leave the office you get sent to the equipment room door where you have to put in the password you just found
public void exit_office() {
	System.out.println("You quitely open the office door and then slip out.");
	equipment_room_door();
}
//This is just the text for the equipment room part
//The player is sent to the getaway part right after
public void equipment_room(){
	System.out.println("You put in the correct password and you enter the equipment room. You grab a guard uniform and put it on.");
	System.out.println("You also grab a keycard. \nThis will allow you to access all areas of the prison but most importantly, this will allow you to exit the prison.");
	System.out.print("You leave the equipment room and slip past all the guards.\n"
			+ "Some of them looked at you suspiciously but lucky for you none of them noticed that you were actually a prisoner. \n"
			+ "You make your way to the enterance of the prison and swipe the keycard to open the door and escape.");
	getaway();
}
//If you type in the wrong password you are sent here
public void equipment_room_fail() {
	System.out.println("You type in the incorrect password this sets off the alarm and the guards catch you. Type a to try again");
	String answer = input.next();
	if (answer.equals("a")) 
		disguise();
	
	else {
		System.out.println("Invalid Answer");
		equipment_room_fail();
	}
}
//You are sent here if you pick the tunnel option
//The player needs to make a distraction in order to dig the tunnel
public void distraction() {
	System.out.print("How would you like to create the distraction?");
	
	System.out.println("\n a. Start a food fight \n b. Clog the toilet");
	
	String answer = input.next();

if (answer.equals("a")) 
	food_fight_distraction();
else if(answer.equals("b"))
	toilet_distraction();

else {
	System.out.println("Invalid Answer");
	distraction();
}

}
//Once again these are the two options for a distraction
public void food_fight_distraction() {
	System.out.println("During lunch, you toss your tomato soup across the room and it lands on someones head. \nBefore you know it, a huge food fight has broken out. \nThis should buy you plenty of time to dig your tunnel.");
	dig_tunnel();
}
//This is the second distraction
public void toilet_distraction() {
	System.out.println("You flush a entire roll of toilet paper at once. This floods the entire bathroom. That should keep the guards busy for quite some time.");
	dig_tunnel();
}

//If you pick the drill to escape you are sent here and then sent to the distraction part
public void tunnel_escape_drill() {
	System.out.println("You call your friend using the jail phone. He sends you a package that contains a drill and lucky for you the guards forgot to check it. Using the drill would be very loud and you do not want to attract guards. You must create a distraction.");
distraction();

}
//If you picked the spoon you are sent here and then sent to the distraction part
public void tunnel_escape_spoon() {
	System.out.println("You steal a spoon during breakfast. You do not want to get spotted while digging your tunnel so you must create a distraction.");
	distraction();
}
//This is where you dig the tunnel. b and c are wrong
public void dig_tunnel() {
	System.out.println("\nYou're ready to begin digging the tunnel. How many feet deep would you like to dig your tunnel?");
	
	System.out.println("\n a. 5 feet \n b. 10 feet \n c. 15 feet");
	
	String answer = input.next();
	
	if (answer.equals("a")) 
		tunnel_success();
	else if(answer.equals("b"))
		tunnel_fail();
	
	else if(answer.equals("c"))
		tunnel_fail();
		
	else {
		System.out.println("Invalid Answer");
		dig_tunnel();
	}

	
}
//If you pick b or c you are sent here. You lose and are given the option to try again
	public void tunnel_fail() {
		System.out.println("When you dig about 9 feet down, you hit a pipe that starts spewing out water which floods your entire tunnel.");
		System.out.println("Type a to try again.");
		String answer = input.next();
		
		
		if (answer.equals("a")) 
			dig_tunnel();
			
		
		else {
			System.out.println("Invalid Answer");
			tunnel_fail();
		}
	}
	//If you pick a you get sent here then sent to the getaway
	public void tunnel_success() {
			System.out.println("You dig your tunnel 5 feet down. You then proceed to dig your tunnel 100 feet foward and after dig up to the surface. \nYou have successfully escaped.");
		getaway();
		}
	//Here's the getaway part. No matter which escape method you use, you'll always end up here
	//This uses the variable from earlier to determine which getaway driver you picked
	public void getaway() {
		if(getawayDriver == 1) {
			System.out.print("\nYou quickly find your getaway driver Jeff and hop into his car. The two of you start driving."
					+ "\nSuddenly you hear the alarms go off and serveral cop cars are chasing you. The guards must have realized you escaped.");
			getawaypt1();
		}
		else if(getawayDriver == 2) {
			System.out.println("\nYou quickly find your getaway driver Elly and hop into her car. The two of you start driving."
					+ "\nSuddenly you hear the alarms go off and serveral cop cars are chasing you. The guards must have realized you escaped.");
			getawaypt1();
		}
		
		else {
		System.out.println("\nYou quickly find your getaway driver Robert and hop into his car. The two of you start driving. "
				+ "\nSuddenly you hear the alarms go off and serveral cop cars are chasing you. The guards must have realized you escaped.");
		getawaypt1();
		}
	}
	//The three parts of the getaway are here
	//If you do this part successfully you win
	//getaway part 1
	public void getawaypt1() {
		System.out.println("\nYou must lose the cops. The road ahead splits into multiple directions. \n \nWhich way would you like to go?");
		System.out.println(" a. Keep going foward \n b. Turn right \n c. Turn left");
		String answer = input.next();
		if (answer.equals("a")) 
			getawaypt2();
		else if(answer.equals("b"))
			getawaypt2();
		else if(answer.equals("c"))
			getawaypt2();
		else {
			System.out.println("Invalid Answer");
			getawaypt1();
		}
	}
	//getaway part 2
	public void getawaypt2() {
		System.out.println("The road ahead splits into two directions. Where would you like to go");
		System.out.println(" a. Turn right \n b. Turn left");
		String answer = input.next();
		if (answer.equals("a")) 
			getawaypt3();
		else if(answer.equals("b"))
			getawaypt3();
		else {
			System.out.println("Invalid Answer");
			getawaypt2();
	}}
	//getaway  part 3
	//b is the only wrong answer
	public void getawaypt3() {
		System.out.println("It's no use. The cops are still onto you. You must think of something else.");
		System.out.println("\nWhat would you like to do?\n\n a. Make a quick turn into the alley\n b. Drive into the woods\n c. Get out of the car and run away.");
		String answer = input.next();
		if (answer.equals("a")) {
			System.out.println("You drive into the alley and lose the cops.");
			youWin();
		}
		else if(answer.equals("b"))
			getaway_fail();
			
		else if(answer.equals("c")) {
			System.out.println("The two of you get out of the car and sprint into the woods. You lost the cops.");
			youWin();
			}
		else {
			System.out.println("Invalid Answer");
			getawaypt3();
			}
	}
	//If you picked b you are sent here
	public void getaway_fail() {
		System.out.println("You drive into the woods and slam into a tree.\n Type a to try again");
		String answer = input.next();
		if (answer.equals("a")) 
			getawaypt3();
		else {
			System.out.println("Invalid Answer");
			getawaypt3();
			}
	}
	
	//If you picked a or c you get sent here
	//The variable from earlier is used to determine which escape you did
	//This also uses the name you entered from the start
	//After you are sent to the end
	public void youWin() {
		if(escape_option == 1) {
			System.out.println("\nCongratulations "+yourName+" You have successfully escaped from prison using the tunnel method.\nThere are two other ways you can escape.");
			end();
			getawaypt1();
		}
		else if(escape_option == 2) {
			System.out.println("\nCongratulations "+yourName+" You have successfully escaped from prison using the window method.\nThere are two other ways you can escape.");
			end();
		}
		
		else {
			System.out.println("\nCongratulations "+yourName+" You have successfully escaped from prison using the disguise method.\nThere are two other ways you can escape.");
			end();
			}
		}
	//If you want to play again you can type a. 
public void end() {
	System.out.println("\n Type a if you'd like to play again.");
	String answer = input.next();
	if (answer.equals("a")) 
		intro();
	
	else {
		System.out.println("Invalid Answer");
		end();
	}
}
//This was used before until I found a better way of doing this
public void input_error() {
	System.out.print("error");
	
	System.out.print("Type a to restart");
String answer = input.next();
	
	
	if (answer.equals("a")) 
		intro();
		
	
	else
		input_error();
}
public static void main(String[] args) {
	
	
	Adventure my_adventure = new Adventure();
	my_adventure.intro();
}
}

