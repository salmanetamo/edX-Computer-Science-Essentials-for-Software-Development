import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	private ArrayList<Actor> actorList;
	
	/**
	 * Constructor of the MovieDatabase class
	 */
	public MovieDatabase() {
		this.movieList = new ArrayList<Movie>();
		this.actorList = new ArrayList<Actor>();

	}

	/**
	 * Returns an arrayList of movies
	 * @return ArrayList<Movie>
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	/**
	 * Returns an arraylist of actors
	 * @return ArrayList<Actor>
	 */
	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	
	/**
	 * Adds new movies to the movieList along with the actors in that movie
	 * @param name
	 * @param actors
	 */
	public void addMovie(String name, String[] actors) {
		if(!movieInDB(name)) {
			ArrayList<Actor> actorsInMovie = new ArrayList<Actor>();
			for(String actorName : actors) {
				ArrayList<Movie> movies = new ArrayList<Movie>();
				Actor actor = new Actor(actorName,movies);
				if(!actorInList(actorName)) {
					this.getActorList().add(actor);
				}
				actorsInMovie.add(actor);
			}
			
			Movie movie = new Movie(name, actorsInMovie, 0.0);
			this.movieList.add(movie);
		}
	}
	
	public void addRating(String name, double rating) {
		for(Movie movie : this.getMovieList()) {
			if(movie.getName().equals(name)) {
				movie.setRating(rating);
			}
		}
	}
	
	public void updateRating(String name, double newRating) {
		for(Movie movie : this.getMovieList()) {
			if(movie.getName().equals(name)) {
				movie.setRating(newRating);
			}
		}
	}
	
	public String getBestActor() {
		Actor bestActor = this.getActorList().get(0);
		for(Actor actor:this.getActorList()) {
			if(getActorAvgRating(actor) > getActorAvgRating(bestActor)) {
				bestActor = actor;
			}
		}
		return bestActor.getName();
	}
	
	public String getBestMovie() {
		Movie bestMovie = this.getMovieList().get(0);
		for(Movie movie:this.getMovieList()) {
			if(movie.getRating() > bestMovie.getRating()) {
				bestMovie = movie;
			}
		}
		return bestMovie.getName();
	}
	
	private double getActorAvgRating(Actor actor) {
		double totalRating = 0;
		for(Movie movie:actor.getMovies()) {
			totalRating += movie.getRating();
		}
		return totalRating/actor.getMovies().size();
	}
	
	/**
	 * Returns true if the movie is already in the arraylist
	 * @param name
	 * @return
	 */
	private boolean movieInDB(String name) {
		for(Movie movie : this.getMovieList()) {
			if(movie.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns true if the actor is already in the actorlist
	 * @param name
	 * @return
	 */
	private boolean actorInList(String name) {
		for(Actor actor : this.getActorList()) {
			if(actor.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MovieDatabase movieDB = new MovieDatabase();
		File moviesFile = new File("movies.txt");
		File ratingsFile = new File("ratings.txt");
		try {
			Scanner scanner = new Scanner(moviesFile);			
			
			ArrayList<String> movieNames = new ArrayList<String>();			
			
			while(scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split(",");
				for(int i= 1; i < line.length; i++) {
					if(!movieNames.contains(line[i])) {
						movieNames.add(line[i]);
					}
				}
			}
			scanner.close();
			for(String movieName:movieNames) {
				Scanner scanner2 = new Scanner(moviesFile);
				ArrayList<String> actorNames = new ArrayList<String>();
				while(scanner2.hasNextLine()) {
					String[] line =scanner2.nextLine().split(",");
					
					for(int i = 1; i < line.length; i++) {
						if(movieName.equals(line[i])) {
							actorNames.add(line[0]);
						}
					}
				}
				String[] actorNamesArray = new String[actorNames.size()];
				movieDB.addMovie(movieName, actorNames.toArray(actorNamesArray));
				scanner2.close();
			}
			Scanner scanner3 = new Scanner(ratingsFile);
			while(scanner3.hasNextLine()) {
				String[] line = scanner3.nextLine().split("	");
				for(Movie movie:movieDB.getMovieList()) {
					if(movie.getName().equals(" "+line[0])) {
						movieDB.updateRating(movie.getName(), Double.parseDouble(line[1]));
					}
				}
			}
			scanner3.close();
			for(Actor actor:movieDB.getActorList()) {
				for(Movie movie:movieDB.getMovieList()) {
					if(movie.getActors().contains(actor)) {
						actor.getMovies().add(movie);
					}
				}
			}
			for(Actor actor:movieDB.getActorList()) {
				System.out.println(actor.getName() +"  "+actor.getMovies().size());
				for(Movie movie:actor.getMovies()) {
					System.out.println(movie.getName() + "  "+movie.getRating());
				}
			}
			System.out.println("Best actor: " + movieDB.getBestActor());
			System.out.println("Best movie: " + movieDB.getBestMovie());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
