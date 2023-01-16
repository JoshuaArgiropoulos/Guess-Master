//Joshua Argiropoulos 20212850

import java.util.Scanner;
import java.util.Random;
//imports needed methods to be used later in the program

public class GuessMaster {
	private int numberOfCandidateEntities = 0;
	private Entity[] entities = new Entity[50];
	//creates array and sets the numb of candidates to 0
	
	private int totalTickets = 0;
	//Sets the users total earned tickets for this game to 0 
	
	public void addEntity(Entity entity) {
		entities [numberOfCandidateEntities] = entity;
		//Adds the entity to the array of candidates
		numberOfCandidateEntities++;
		//increases shifts the array to allow for more entities 
		
	}
	public void startGame() {
		System.out.println("Welcome to GuessMaster! Please input a number to select a birthday to guess!\n");
		//Asks user to select which birthday to guess
		for (int i = 0; i < this.numberOfCandidateEntities; i++) {
			System.out.println("Option "+(i+1)+". "+ entities[i].getName()+".\n");
			//displays the options to the user
		}
		System.out.println("Option "+(this.numberOfCandidateEntities+1)+". Random Selection.\n");
		//Creates an option for the user to select an option that gives the user a random assignment 
		Scanner num = new Scanner(System.in);
		int ID = num.nextInt();
		//Get the input of user for which birthday selected
		while (ID < 1 || ID > (this.numberOfCandidateEntities+1)) {
			//Ensures the users choice is within the selected options and if it isnt, opts the user in to selecting a valid option 
			System.out.println("Please select a valid number.\n");
			ID = num.nextInt();
			//If the option was not listed and the user selected out of the range, asks the user to pick a valid choice 
		}
		
		// Checks if user selected random entry, +2 to number of candidates. 
		//First +1 because 0 is not an option the user selects and 
		//its another +1 because random selection occurs after all options are presented 
		if (ID == this.numberOfCandidateEntities+1) {
			//If the last option is selected, it picks a random birthday for the user to guess
			Random rand = new Random();
			int max = this.numberOfCandidateEntities;
			
			playGame(rand.nextInt(max));
		}
		else
			playGame(ID -1);
		
		//Starts the game and matches the users choice with the corresponding ID in the array 
	}
	public void playGame(int entity) {
		//Prints welcome message
		System.out.println(entities[entity].welcomeMessage()+"\n");
		
		System.out.println("Try guessing " + entities[entity].getName()+"'s birthday! (MM/DD/YYYY)\nType \"quit\" to exit the game.\n" );
		//informs user of which entity can be selected to guess and the format which the program accepts
		Scanner newDate = new Scanner(System.in);
		
		//obtains the users input
		boolean correct = false;
		//creates a loop that forces the user to keep guessing if they are not correct
		while (correct!=true) {
			String guess = newDate.nextLine();
			//Gets users input and checks if the input is quit before turning into date
			if (guess.equals("quit")) {
				System.exit(0);
				//Quits game if user types quit
			}
			Date attempt = new Date(guess);
			if (entities[entity].getBorn().equals(attempt)){
				System.out.println("You have correctly guessed the birthday!\n");
				
				System.out.println(entities[entity].closingMessage()+"\n");
				//Prints the detailed info of the entity 
				totalTickets = totalTickets + entities[entity].getAwardedTicketNumber();
				//Calculates the new total tickets for the user
				
				System.out.println("You won "+ entities[entity].getAwardedTicketNumber() +" tickets in this round!\nThe total number of your tickets is "+totalTickets+"!\n");
				//Displays number of tickets earned this round and while playing the game
				
				
                correct = true;
                //Checks if the selected entity birthday is equal to the date guessed 
                //Breaks the loop and congratulates the winner
            }
			
			else if (entities[entity].getBorn().precedes(attempt)) {
				System.out.println("Try an earlier date!\n");
				//Informs user that the date selected was later than the birth date and to try guessing again 
				//Checks if the guess was later than the entity's birthday
			}
			else {
				System.out.println("Try a later date!\n");
				//informs the user the date is too early 
			}
			
		}
		System.out.println("Enter \"yes\" if you would like to keep playing!");
		//option to keep playing or to quit game
		
		Scanner word = new Scanner(System.in);
		String answer = word.nextLine();
		//Obtains the users answer if they would like to keep playing
		
		if (answer.equals("yes")) {
			startGame();
			//brings back to selection menu
		}
		else 
			System.out.println("Thank you for playing!\n");
			System.exit(0);
			//Exits game and thanks user for playing
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25,1971), "Male", "Liberal", 0.25);
		
		Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
		
		Person Rachel = new Person("Rachel Rousseau", new Date("September", 1, 2002),"Female", 1);
		
		Person myCreator = new Person("myCreator", new Date("September", 1, 2000),"Female", 1);
		
		Country usa = new Country("United States", new Date("July", 4, 1776), "Washinton D.C.", 0.1);
        //Creates entities for the game to use
        
		
        GuessMaster gm = new GuessMaster();
        
        gm.addEntity(trudeau);
        gm.addEntity(dion);
        gm.addEntity(usa);
        gm.addEntity(Rachel);
        gm.addEntity(myCreator);
        
        //Inputs entities for the game to use
        
        gm.startGame();
        //Starts game
	}


}

