import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WordBank {
	
	private BufferedReader f;
	private PrintWriter out;
	private ArrayList<Word> wordBank;
	
	public WordBank() throws IOException{
		f = new BufferedReader(new FileReader("WordBank.in"));
		wordBank = new ArrayList<Word>();
		for(int i = 0; i<1200; i++) {
			Word word = new Word(f.readLine());
			wordBank.add(word);
		}
	}
	public Word getWord() throws IOException {
		
		int x = (int) (Math.random()*wordBank.size());
		return wordBank.remove(x);
		
	}
	
	
	
}
