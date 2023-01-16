//Joshua Argiropoulos 20212858
public class Person extends Entity {
	private String gender;
	
	public Person(String setName, Date setBorn, String setGender, double setDifficulty) {
		super(setName, setBorn, setDifficulty);
		gender = setGender;
		//Uses entity class for its constructor and also sets the gender with its own constructor 
	}
	public Person(Person person) {
		super(person);
		gender = person.gender;
		//Copy constructors using the entity class and copies the gender
	}
	public String getGender() {
		return (gender);	
		//Returns the gender of the person 
	}
	public void setGender(String setGender) {
		gender = setGender;
		//Sets the gender of the person
	}
	public String entityType() {
		return (" person!");
		//Sets the entity type that will be used by entity class
	} 
	public Entity clone() {
		return (new Person(this));
		//Clones the object 
	}
	public String toString() {
		return (super.toString()+"\nGender: "+ gender);
		//Adds additional info to the toString method
	}

}



