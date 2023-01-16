//Joshua Argiropoulos 20212858
public class Singer extends Person{
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	//Instance variables to be used by singer class
	
	public Singer(String setName, Date setBorn, String setGender, String setDebutAlbum, Date setDebutAlbumReleaseDate, double setDifficulty) {
		super(setName, setBorn, setGender, setDifficulty);
		debutAlbum = setDebutAlbum;
		debutAlbumReleaseDate = setDebutAlbumReleaseDate;
		//Constructor used to set debut album and debut album release date, in addition it calls upon the constructor from person 
		
		
	}
	public Singer(Singer singer) {
		super(singer);
		debutAlbum = singer.debutAlbum;
		debutAlbumReleaseDate = singer.debutAlbumReleaseDate;
		//Copy constructor used to prevent data leaks by calling upon the method in persons and also copying debut and debut release date 
	}
	public String getDebutAlbum() {
		return (debutAlbum);	
		//Returns album name
	}
	public void setDebutAlbum(String setDebutAlbum) {
		debutAlbum = setDebutAlbum;
		//sets debut album
	}
	public Date getDebutAlbumReleaseDate() {
		return (new Date(debutAlbumReleaseDate));	
		//returns debut album release date 
	}
	public void setDebutAlbum(Date setDebutAlbumReleaseDate) {
		debutAlbumReleaseDate = setDebutAlbumReleaseDate;
		//Sets debut album release date
	}
	public String entityType() {
		return (" singer!");
		//Sets the entity type to be used by the entity class and method entityType()
		
	} 
	public Entity clone() {
		return (new Singer(this));
		//Used to create a copy of the object
	}
	public String toString() {
		return (super.toString()+"\nDebut Album: "+ debutAlbum+"\nDebut Album Release Day: "+debutAlbumReleaseDate);
		//Adds addtional info onto the toString method from entity 
	}
	


}
