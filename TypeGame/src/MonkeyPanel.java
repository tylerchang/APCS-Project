import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MonkeyPanel extends JComponent{
    private ImageIcon monkey;
    private ImageIcon lava;
    private ImageIcon rope;
    private ImageIcon mountain;
    private int monkeyX;
    private int monkeyY;
    private int lavaX;
    private int lavaY;
    private int ropeX;
    private int ropeY;
    private int mountainX;
    private int mountainY;
    private Timer timer;
	private TimerTask timerTask;
    

    public MonkeyPanel(){
        monkey = new ImageIcon("monkey.png");
        monkeyX = 368;
        monkeyY = 20;
        lava = new ImageIcon("lava.jpg");
        lavaX = 5;
        lavaY = 770;
        rope = new ImageIcon("rope.png");
        ropeX = 100;
        ropeY = 10;
        mountain = new ImageIcon("volcano.jpg");
        mountainX = 0;
        mountainY = 0;
        timer = new Timer();
        timerTask = new TimerTask(){
			public void run() {
				if(monkeyY < 700) {
					monkeyY+=30;
				}
				repaint();
			}
        };
        
        timer.schedule(timerTask,1000, 1000);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.drawImage(mountain.getImage(), mountainX, mountainY, this);
    	g.drawImage(lava.getImage(), lavaX, lavaY, this);
    	g.drawImage(rope.getImage(), ropeX, ropeY, this);
    	g.drawImage(monkey.getImage(), monkeyX, monkeyY, this);
    	g.drawString(" "+ monkeyY, 40, 40);
		
	}
	
}