import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WordBank {
	
	private BufferedReader f;
	private PrintWriter out;
	
	public WordBank() throws IOException{
		f = new BufferedReader(new FileReader("WordBank.in"));
	}
	public Word getWord() throws IOException {
		String line =  f.readLine();
		Word word = new Word(line);
		return word;
		
	}
	
	
	
}
