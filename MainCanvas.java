import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class MainCanvas extends JComponent{
	private final int WIDTH;
	private final int HEIGHT;
	
	public MainCanvas(int W, int H) {
		WIDTH = W;
		HEIGHT = H;
	}
	
	public void paintComponent(Graphics gr){
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.orange);
		g.fillRect(0,0, 20, 20);
	}
}
