package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename) throws IOException{
		lines = new ArrayList<>();
		//TODO: Open the filename, read in the data into the lines array list, and close the file when done...
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// Methods
	public int getNumberOfLines(){
		// TODO
		return lines.size();
	}
	
	public String getLine(int index){
		// TODO
		return lines.get(index);
	}
}
