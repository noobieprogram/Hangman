import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Word word;
	private static String asterisk;
	private static int count = 0;
	private static Random rand = new Random();
	private static int max_errors;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		word = new Word(rand.nextInt(370093));
		asterisk = new String(new char[word.getLength()]).replace("\0", "*");
		
		System.out.println("How many guesses would you like?");
		max_errors = sc.nextInt();
		
		while (count < max_errors && asterisk.contains("*")) {
			System.out.println("Guess any letter in the word.");
			System.out.println(asterisk);
			String guess = sc.next();
			hang(guess);
		}
		sc.close();
	}

	public static void hang(String guess) {
		String correct = "";
		for (int i = 0; i < word.getLength(); i++) {
			if (word.getWord().charAt(i) == guess.charAt(0)) {
				correct += guess.charAt(0);
			} else if (asterisk.charAt(i) != '*') {
				correct += word.getWord().charAt(i);
			} else {
				correct += "*";
			}
		}

		if (asterisk.equals(correct)) {
			count++;
			int remaining = max_errors - count;
			System.out.println("You have " + remaining + " tries remaining.");
			hangmanImage();
		} else {
			asterisk = correct;
		}
		if (asterisk.equals(word.getWord())) {
			System.out.println("Correct! You win! The word was " + word.getWord() + "!");
		}
	}

	public static void hangmanImage() {
		if (count == max_errors) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + word.getWord() + "!");
		}
	}
}