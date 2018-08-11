import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	private static int errors = 0; // can also be named as 'score'
	private final static int max_errors = 11; // maximum number of errors allowed
	static Random rand = new Random();
	static char[] chars; // the randomly chosen word is passed to this array
	static int length; // length of the word
	static char[] ans_check; // temporary array

	// does all the character checking and error counting
	public static void error() {

		while ((errors < max_errors) && (!Arrays.equals(ans_check, chars))) {
			char c = sc.nextLine().charAt(0); // takes only the first character of entered string
			for (int i = 0; i < chars.length; i++) {
				if (c == chars[i]) {
					ans_check[i] = c;
				} else {
					errors++;
				}
			}
		}
		if (Arrays.equals(ans_check, chars)) {
			System.out.println("You got it");
			return;
		} else if (errors >= max_errors) {
			System.out.print("You lost!");
			return;
		}
	}

	public static void main(String[] args) {

		// A simple start up message
		System.out.println("Welcome! This is a simple Hangman game. "
				+ "The rules are simple, everytime the enter key is pressed a new random word is generated. "
				+ "You are required to enter one character everytime. The result will be displayed once you enter 11 wrong charcters or succeed.");

		String init = sc.nextLine();

		// type "yes" to initiate the game
		if (init.equals("yes")) {
			Word word = new Word(rand.nextInt(370093));
			chars = word.getCharacters();
			length = word.getLength();
			ans_check = new char[length];
			System.out.println(word.getWord());
			error();
		} else {
			System.out.println("wut");
		}
	}
}
