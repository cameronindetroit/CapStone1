package pigLatin.grandcircus;
/*
 * Cameron Barnes 7/20/2018
 * Grand Circus Bootcamp Q3
 * 
 */

import java.util.Scanner;

public class PigLatin {

	/*
	 * Pig Latin Rules {a,e,i,o,u} vowels, Starting consonants flipped to end of
	 * word. -ay is added to end of the word if word starts with vowel, add (way)
	 * onto the ending
	 */

	public static void main(String[] args) {

		// Class variables
		String userInput;
		String translatedSentence;
		String continueYesOrNo;

		// Scanner
		Scanner scnr = new Scanner(System.in);

		// Loop program to continue if user chooses
		do {

			// Introduction to program
			System.out.println("Welcome to the Pig Latin Transaltor!");

			// Prompt user for word/Sentence to translate
			System.out.println("Enter a word/sentence to be translated");
			userInput = scnr.nextLine();

			// Test Translated sentence
			translatedSentence = sentanceSeparator(userInput);
			System.out.println(translatedSentence);

			// Ask if user would like to continue
			System.out.println("\nTry again? Y/N");
			continueYesOrNo = scnr.nextLine();

		} while (continueYesOrNo.trim().toLowerCase().startsWith("y"));

		// Exit Program
		System.out.println("Exiting Program");

		// close scanner
		scnr.close();
	}

	// Method to convert String to Pig Latin
	private static String pigLatinTranslator(String word) {
		// Convert word to lowercase
		String tempWord = word.toLowerCase();
		// Locate first letter in word
		char firstLetter = tempWord.charAt(0);

		// Array to store all vowels
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

		// For loop to iterate through the vowels array and assigning that vowel to the
		// index of (i)
		for (int i = 0; i < vowels.length; i++) {

			// Conditional to check if first letter is vowel or not
			if (firstLetter == vowels[i]) {
				tempWord += "way";
				return tempWord;

			} else if (firstLetter != vowels[i]) {

				// Find first vowel in word

				// remove all consonants before vowel

				// reconstruct word to pigLatin

			}
		}

		tempWord = tempWord.substring(1);
		tempWord += firstLetter + "ay";

		return tempWord;

	}

	// Method to convert user input into individual strings to be translated and
	// passed through the PigLatin Translator
	private static String sentanceSeparator(String sentence) {

		String tempSentence = sentence;
		String pigLatinSentence = " ";
		String individualWord;
		String[] seperatedWords = tempSentence.split(" ");

		for (String word : seperatedWords) {

			individualWord = word;
			individualWord = pigLatinTranslator(individualWord);
			pigLatinSentence += individualWord + " ";

		}

		return pigLatinSentence.trim();

	}

}
