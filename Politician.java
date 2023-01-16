//Joshua Argiropoulos 20212858
public class Politician extends Person{
	private String party;
	
	public Politician(String setName, Date setBorn, String setGender, String setParty, double setDifficulty) {
		
		super(setName, setBorn,setGender, setDifficulty);
		party = setParty;
		//Uses constructor provided by Persons and sets the party 
	}
	public Politician(Politician politician) {
		super(politician);
		party = politician.party;
		//Uses copy constructor by persons and copies the party 
	}
	public String getParty() {
		return (party);	
		//Returns the party of the politician 
	}
	public void setParty(String setParty) {
		party = setParty;
		//Sets the party of the politician 
	}
	public String entityType() {
		return (" politician!");
		//Adds the info for entity to use in the welcome message method
	} 
	public Entity clone() {
		return (new Politician(this));
		//Clones the object
	}
	public String toString() {
		return (super.toString()+"\n Party: "+ party);
		//Adds the info to toString to produce a completed sentence 
	}
	

}
