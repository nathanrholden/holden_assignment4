
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class DuplicateRemover {
	
	//Array of Strings used to store unique words.
	private String[] uniqueWords;
	//Store the current length of uniqueWords.
	private int wordCount;
	//Remove repeated words and add them all to the uniqueWords Array.
	public void remove(String dataFile) {
		uniqueWords = new String[500];
		
		File myFile = new File(dataFile);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));
			String line;
			String[] splitLine;
			wordCount = 0;
			//Read in each line from the file (I personally put all the words on one line, but theoretically you could use multiple).
			while((line = reader.readLine()) != null) {
				splitLine = line.split(" ");
				//Take each word from the line and perform checks on it.
				for(int i = 0; i < splitLine.length; i++) {
					splitLine[i] = splitLine[i].toLowerCase();
					int found = 0;
					//Check if each word in the file has already been placed in uniqueWords.
					for(int j = 0; j < wordCount; j++) {
						if(splitLine[i].equals(uniqueWords[j])) {
							found = 1;
						}
					}
					//If a word is not found in uniqueWords, add it.
					if(found != 1) { 
						uniqueWords[wordCount] = splitLine[i]; 
						wordCount++; 
					}
				}
			}
			//Save memory, close your allocated memory.
			reader.close();
		//Catch all those pesky IO exceptions. Add an entirely unhelpful print.	
		} catch (IOException e) {
			System.out.println("An IO Exception has occurred while reading in the 'problem1.txt' file. Please check that this file exists.");
		}
		
	}
	
	public void write(String outputFile) {
		File myFile = new File(outputFile);
		try {
			myFile.createNewFile();
			FileWriter write = new FileWriter(outputFile);
			//Take each word from unique words and write it to the output file.
			for(int i = 0; i < wordCount; i++) {
				write.write(uniqueWords[i]);
				write.write(" ");
			}
			
			write.close();
		//Catch IOExceptions again.
		} catch (IOException e) {
			System.out.println("An IO Exception has occured while writing the 'unqiue_words.txt' file.");
		}
	}
}
