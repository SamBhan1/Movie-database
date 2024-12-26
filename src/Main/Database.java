package Main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	public Scanner scan;
	
	// Constructor
	public Database(String filename, Scanner scan2) throws IOException{
		movies = new ArrayList<>();
		fileRead fr = new fileRead("db.txt");
	    this.scan = scan2; 
		
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String raw = fr.getLine(i);
			// TODO: Parse using the StringTokenizer here and place into movies as single entries...
			StringTokenizer st = new StringTokenizer(raw,"/");
			String Title = st.nextToken();
			String Actor1 = st.nextToken();
			String Actor2 = st.nextToken();
			String Director = st.nextToken();
			int Year = Integer.parseInt(st.nextToken());
			int runTime = Integer.parseInt(st.nextToken());
			Movie movie = new Movie(Title,Actor1,Actor2,Director,Year,runTime);
			movies.add(movie);
		}
		
	}
		
		
	public void addEntry() {
	    System.out.println("Enter the title:");
	    String title = scan.nextLine();

	    System.out.println("Enter Actor 1:");
	    String actor1 = scan.nextLine();

	    System.out.println("Enter Actor 2:");
	    String actor2 =scan.nextLine();

	    System.out.println("Enter the Director:");
	    String director = scan.nextLine();

	    System.out.println("Enter the year:");
	    int year;
	    while (true) {
	        try {
	            year = Integer.parseInt(scan.nextLine());
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid year:");
	        }
	    };


	    System.out.println("Enter the runtime:");
	    int runtime;
	    while (true) {
	        try {
	            runtime = Integer.parseInt(scan.nextLine());
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input. Please enter a valid runtime:");
	        }
	    };
	    
	    // Confirm the data with the user
	    System.out.println("\nConfirm the movie details:");
	    System.out.println("Title: " + title);
	    System.out.println("Actor 1: " + actor1);
	    System.out.println("Actor 2: " + actor2);
	    System.out.println("Director: " + director);
	    System.out.println("Year: " + year);
	    System.out.println("Runtime: " + runtime + " minutes");

	    System.out.println("\nIs this information correct? (yes/no)");
	    String confirmation = scan.nextLine().trim().toLowerCase();

	    if (confirmation.equals("yes")) {
	        // Create and add the movie
	        Movie movie = new Movie(title, actor1, actor2, director, year, runtime);
	        movies.add(movie);
	        System.out.println("Movie added successfully!");
	    } else {
	        System.out.println("Movie addition canceled.");
	    }
	}

	
	public Movie searchByTitle(String title){
		// TODO
		for(Movie movie:movies) {
			if(movie.getTitle().equalsIgnoreCase(title)) {
				return movie;
		}
			else {
				System.out.println("Movie not found");
			}

	}
		return null;
	}

	
	public Movie searchByActor(String actor){
		// TODO
		for(Movie movie:movies) {
			if( movie.getActor1().equalsIgnoreCase(actor) || movie.getActor2().equalsIgnoreCase(actor)) {
				return movie;
			}
			else {
				System.out.println("Actor not found");
			}
		}
		return null;
	}
	
	public Movie searchByDirector(String director){
		// TODO
		for(Movie movie:movies) {
			if( movie.getDirector().equalsIgnoreCase(director)) {
				return movie;
			}
			else {
				System.out.println("Director not found");
			}
		}
		return null;
	}
	
	public Movie searchByYear(int year){
		// TODO
		for(Movie movie:movies) {
			if( movie.getYear() == year) {
				return movie;
			}
			else {
				System.out.println("Movie not found");
			}
		}
		return null;
	}
	
	public Movie searchByRuntime(int runtime){
		// TODO
		for(Movie movie:movies) {
			if( movie.getRuntime() == runtime) {
				return movie;
			}
			else {
				System.out.println("Movie not found");
			}
	}
		return null;
	
	}
}


