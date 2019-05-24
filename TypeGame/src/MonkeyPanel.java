import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MonkeyPanel extends JComponent{
    private ImageIcon monkey;
    private ImageIcon lava;
    private ImageIcon rope;
    private int monkeyX;
    private int monkeyY;
    private int lavaX;
    private int lavaY;
    private int ropeX;
    private int ropeY;
    

    public MonkeyPanel(){
        monkey = new ImageIcon("monkey.png");
        monkeyX = 370;
        monkeyY = 20;
        lava = new ImageIcon("lava.jpg");
        lavaX = 0;
        lavaY = 700;
        rope = new ImageIcon("rope.png");
        ropeX = 100;
        ropeY = 10;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.drawImage(monkey.getImage(), monkeyX, monkeyY, this);
    	g.drawImage(lava.getImage(), lavaX, lavaY, this);
    	g.drawImage(rope.getImage(), ropeX, ropeY, this);

		
	}
	
}