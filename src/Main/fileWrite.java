/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		// TODO: Add the newLine to the writeBuffer...
		writeBuffer.add(newLine);
		
	}
	
	public void saveFile(){
		// TODO: Save all of the lines in the writeBuffer to the file (given in filename)
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write all lines in the writeBuffer to the file
            for (String line : writeBuffer) {
                writer.write(line);  // Write the line to the file
                writer.newLine();     // Ensure each line ends with a new line
            }
            System.out.println("File saved.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
		
	}
}
