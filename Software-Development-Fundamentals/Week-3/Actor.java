import java.util.*;


public class Actor {
	private String name;
	private ArrayList<Movie> movies;
	
	public Actor(String name, ArrayList<Movie> movies) {
		this.name = name;
		this.movies = movies;
	}

	/**
	 * Returns the name of this actor
	 * @return String name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the movies of this actor
	 * @return String name
	 */
	public ArrayList<Movie> getMovies() {
		return this.movies;
	}
	
	/**
	 * Set the name of the actor to new name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
