
public class Word {
	private String word;
	private int x;
	private int y;
	
	public Word(String word) {
		this.word = word;
		x = 50;
		y = 50;
	}
	public String getText() {
		return word;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
