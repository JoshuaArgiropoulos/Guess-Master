//Joshua Argiropoulos 20212858

public abstract class Entity {
	private String name;
	private Date born;
	private double difficulty; 
	//Instance variables to be used 
	
	
	//Class constructor to initialize variables    
	public Entity (String setName, Date setBorn, double setDifficulty) {
		name = setName;
		born = setBorn;
		difficulty = setDifficulty;
	}
	//Copy constructor used to prevent privacy leaks 
	public Entity(Entity setEntity) {
		name = setEntity.name;
		//String is not mutable, therefore privacy leaks cannot occur 
		born = new Date(setEntity.born);
		difficulty = new double(setEntity.difficulty);
	}
	
	public String toString() {
		return (name + "\nBorn on " + new Date(born));
	}
	//Checks if the entity name and birth date are the same and returns true if they are 
	public boolean equals(Entity object) {
		return(object.getName().equals(name) && object.getBorn().equals(new Date(born)));
	}
	//returns name of entity
	public String getName() {
		return(name);
	}
	//returns birth date of entity without privacy leaks
	public Date getBorn() {
		return new Date(born);
	}
	public void setDifficulty(double setDifficulty) {
		difficulty = setDifficulty;
		//Creates a method which sets the difficulty 
	}
	public double getDifficulty() {
		return difficulty;
		//Creates a method which returns the difficulty 
	}
	public int getAwardedTicketNumber() {
		double tickets = getDifficulty() * 100;
		int earnedTickets = (int)tickets;
		return (earnedTickets);
		//Creates a method which find the amount of tickets earn, this can be calculated by getting the difficulty and multiplying by 100
		//The output must be type casted to an int as tickets dont have decimals 
		
	}
	public abstract String entityType();
	public abstract Entity clone();
	//Creates abstract methods that will be used by subclasses to find the info for welcome message and closing message
	
	public String welcomeMessage() {
		return ("Welcome! Let’s start the game! This entity is a" + entityType());
		//Creates a welcome message and tells the user the entity type
		
	}
	
	public String closingMessage() {
		return ("Congratulations! The detailed information of the entity that you have guessed is: \n" + toString() );
		//Creates a closing message and tells the user info about the subject
		
	}
	

}
