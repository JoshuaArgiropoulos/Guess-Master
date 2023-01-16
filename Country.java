//Joshua Argiropoulos 20212858
public class Country extends Entity{
	private String capital;
	//Creates instance variable capital
	
	public Country(String setName, Date setBorn, String setCapital, double setDifficulty) {
		//Creates a constructor for the country class which uses the constructor from entity and also sets capital  
		super(setName, setBorn, setDifficulty);
		capital = setCapital;
	}
	public Country(Country country) {
		super(country);
		capital = country.capital;
		//Copy constructor to ensure no data leaks occur 
	}
	public String getCapital() {
		return (capital);	
		//Returns the capital of the country 
	}
	public void setCapital(String setCapital) {
		capital = setCapital;
		//Sets the capital of the country
	}
	public String entityType() {
		return ("Country");
		//Using the abstract method from entity, allows entity to display country 
	} 
	public Entity clone() {
		return (new Country(this));
		//Creates a method which clones the object 
	}
	public String toString() {
		return (super.toString()+"\nCapital: "+ capital);
		//Adds onto the toString of entity and adds the portion 
	}

}
