/*
 * Nathan Holden Assignment 4: Problem 1
 * COP3330-20Spring 0002
 */

public class Application {
	//Main method used to run the program
	public static void main(String[] args) {
		
		DuplicateRemover duplicateRemover = new DuplicateRemover();
		//read in input from file and store unique words.
		duplicateRemover.remove("problem1.txt");
		//write unique words to output.
		duplicateRemover.write("unique_words.txt");
		
	}

}
