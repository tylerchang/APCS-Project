import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class GamePanel extends JPanel{
	private final int WIDTH;
	private final int HEIGHT;
	MonkeyPanel monkeyPanel;
	TypingPanel typingPanel; 
	
	public GamePanel(int W, int H) throws IOException {
		WIDTH = W;
		HEIGHT = H;
		monkeyPanel = new MonkeyPanel();
		monkeyPanel.setPreferredSize(new Dimension(WIDTH/2,HEIGHT));
		typingPanel = new TypingPanel();
		typingPanel.setPreferredSize(new Dimension(WIDTH/2, HEIGHT));
		
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
