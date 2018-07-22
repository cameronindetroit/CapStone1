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

		// test word to find index of vowel to lowercase
		int testWord = tempWord.length();

		// variable used to locate first letter in word
		char firstLetter = tempWord.charAt(0);

		// variable Locate first vowel in word
		char vowel;

		// Array to store all vowels
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

		// Part 1:
		// For loop to iterate through the vowels array and assigning that vowel to the
		// index of (i)
		for (int i = 0; i < vowels.length; i++) {

			// Conditional to check if first letter is vowel or not
			if (firstLetter == vowels[i]) {
				tempWord = tempWord += "way";
				return tempWord;

			}

		}

		// Part 2:
		// For loop to iterate through word to find first vowel
		for (int j = 0; j < testWord; j++) {

			vowel = tempWord.charAt(j);

			// Conditional to check if word contains a vowel and it's index
			if (vowel == 'a' || vowel == 'e' || vowel == 'i' || vowel == 'o' || vowel == 'u') {

				String firstPartOfWord = tempWord.substring(0, j);
				String secondPartOfWord = tempWord.substring(j);
				String finalString = secondPartOfWord + firstPartOfWord + "ay";
				tempWord = finalString;
				return tempWord;

			}
		}

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
