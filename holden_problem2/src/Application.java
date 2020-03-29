/*
 * Nathan Holden Assignment 4: Problem 2
 * COP3330-20Spring 0002
 */

public class Application {
	//Main method used to run program.
	public static void main(String[] args) {
		
		DuplicateCounter duplicatecounter = new DuplicateCounter();
		//read input from file and count how many times each word is used.
		duplicatecounter.count("problem2.txt");
		//output how many times each word is used to an output file.
		duplicatecounter.write("unique_word_counts.txt");
	}

}
