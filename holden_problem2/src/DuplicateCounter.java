
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.FileWriter;

public class DuplicateCounter {
	
	private Map<String, Integer> countMap;
	
	public void count(String dataFile) {
		countMap = new HashMap<String, Integer>();
		
		File myFile = new File(dataFile);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));
			String line;
			String[] splitLine;
			
			//Read in each line from the file (I personally put all the words on one line, but theoretically you could use multiple).
			while((line = reader.readLine()) != null) {
				splitLine = line.split(" ");
				//Take each word from the line and perform checks on it.
				for(int i = 0; i < splitLine.length; i++) {
					splitLine[i] = splitLine[i].toLowerCase();
					
					if(!countMap.containsKey(splitLine[i])) {
						countMap.put(splitLine[i], 1);
					} else {
						int currentVal = countMap.get(splitLine[i]);
						currentVal++;
						countMap.put(splitLine[i], currentVal);
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
			for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
				write.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
			
			write.close();
		//Catch IOExceptions again.
		} catch (IOException e) {
			System.out.println("An IO Exception has occured while writing the 'unqiue_words.txt' file.");
		}
	}
}
