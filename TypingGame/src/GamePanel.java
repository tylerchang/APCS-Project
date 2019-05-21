import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel{
	private final int WIDTH;
	private final int HEIGHT;
	MonkeyPanel monkeyPanel = new MonkeyPanel(700,350);
	TypingPanel typingPanel = new TypingPanel(700,350);
	
	public GamePanel(int W, int H) {
		WIDTH = W;
		HEIGHT = H;
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		setUp();
	}

	public void setUp(){
		
		GridLayout grid = new GridLayout(1,2);
		this.setLayout(grid);
		this.add(monkeyPanel);
		this.add(typingPanel);
	}

}
