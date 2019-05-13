import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ClickBait2Canvas extends JComponent {
	
	private Image im;
	private int imageX;
	private int imageY;
	private final int WIDTH;
	private final int HEIGHT;
	private int score;
	
	public ClickBait2Canvas(int wIn, int hIn) {
		WIDTH = wIn;
		HEIGHT = hIn;
		im = new ImageIcon("horse.jpg").getImage();
//		imageX = WIDTH/2;
//		imageY = HEIGHT/2;
		moveImage();
		score = 0;
	}
	
	public void paintComponent(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.drawImage(im,imageX,imageY,this);
		g.drawImage(im, imageX, imageY, this);
		g.drawString("Score: " + score, 5, 15);
	}
	
	public void moveImage() {
		imageX = (int)(Math.random()*(WIDTH - im.getWidth(this)));
		imageY = (int)(Math.random()*(HEIGHT - im.getHeight(this)));
		repaint();
	}
	
	public void checkClick(int xIn, int yIn) {
		if(xIn >= imageX && xIn <= imageX + im.getWidth(this) && yIn >= imageY && yIn <= imageY + im.getHeight(this)) {
			score +=1;
			repaint();
		}
	}

	public void resetScore() {
		score = 0;
		repaint();
	}
	
	
	
}
