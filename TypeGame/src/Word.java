
public class Word {
	private String word;
	private int x;
	private int y;
	private boolean draw;
	
	public Word(String word) {
		this.word = word;
		draw = false;
		x = (int)(Math.random()*500 + 100);
		y = 900;
	}
	public String getText() {
		draw = true;
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
