import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Word {

	private File f = new File("words.txt");
	private int length;
	private ArrayList<String> words = new ArrayList<String>();
	private int index;
	private String word_found;

	public Word(int n) {
		this.index = n;
		readFile();
		word_found = words.get(index);
		this.length = word_found.toCharArray().length;
	}

	public int getLength() {
		return length;
	}

	public String getWord() {
		return word_found;
	}

	public char[] getCharacters() {
		return word_found.toCharArray();
	}

	public void readFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line;
			while ((line = br.readLine()) != null) {
				words.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
