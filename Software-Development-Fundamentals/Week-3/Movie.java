import java.util.*;

public class Movie {
	private String name;
	private ArrayList<Actor> actors;
	double rating;
	
	/**
	 * Constructor of the Movie class
	 * @param name
	 * @param actors
	 * @param rating
	 */
	public Movie(String name, ArrayList<Actor> actors, double rating) {
		this.name = name;
		this.actors = actors;
		this.rating = rating;
	}
	
	/**
	 * Returns the name of the movie
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the movie
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the arraylist of actors
	 * @return ArrayList<Actor> actors
	 */
	public ArrayList<Actor> getActors() {
		return actors;
	}
	
	/**
	 * Set the arraylist of actors 
	 * @param actors
	 */
	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}
	
	/**
	 * Returns the rating of the movie
	 * @return double rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Set the rating of the movie
	 * @param rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
}
