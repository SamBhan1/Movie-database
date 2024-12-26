package Main;

import java.io.IOException;
import java.util.Scanner;
import Main.Database;

class Main{
	public static void main(String[] args) throws IOException {
		 System.out.println("Welcome to the great collector");
		 
		 Scanner scan = new Scanner(System.in);
		 Database database = new Database("db.txt",scan);
		 
		 while(true) {
             System.out.println("Enter a command:");
             System.out.println("1. New Entry");
             System.out.println("2. Search by Title");
             System.out.println("3. Search by Actor");
             System.out.println("4. Search by Director");
             System.out.println("5. Search by Year");
             System.out.println("6. Search by Runtime");
             System.out.println("7. Quit");
			 String command = scan.nextLine().toLowerCase();
			 	
				switch(command) {
			 		case "new entry":
			 			database.addEntry();
			 			break;
			 		case "search by title":
			 			String userTitle = scan.nextLine().toLowerCase();
			 			database.searchByTitle(userTitle);
			 				break;
			 		case "search by actor":
			 			String userActor = scan.nextLine().toLowerCase();
				 		database.searchByActor(userActor);
			 				break;
			 		case "search by director":
			 			String userDirector = scan.nextLine().toLowerCase();
				 		database.searchByDirector(userDirector);
			 				break;
			 		case "search by year":
			 			int userYear = scan.nextInt();
				 		database.searchByYear(userYear);
			 				break;
			 		case "search by runtime":
			 			int userRuntime = scan.nextInt();
				 		database.searchByRuntime(userRuntime);
			 				break;
			 		case "quit":
			 			System.out.println("Have a great one!");
			 			scan.close();
			 			return;
			 		default:
			 			System.out.println("Invalid command. Try again");
			 			
				}
		 }
 	}
}