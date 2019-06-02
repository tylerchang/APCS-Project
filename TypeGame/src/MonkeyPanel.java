import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MonkeyPanel extends JComponent{
    private ImageIcon monkey;
    private ImageIcon monkeyDead;
    private ImageIcon lava;
    private ImageIcon rope;
    private ImageIcon mountain;
    public static boolean gameOver;
    private int monkeyX;
    private static int monkeyY;
    private int lavaX;
    private int lavaY;
    private int ropeX;
    private int ropeY;
    private int mountainX;
    private int mountainY;
    public static Timer monkeyTimer;
	private TimerTask timerTask;
    

    public MonkeyPanel(){
    	gameOver = false;
    	if(!gameOver) {
    		monkey = new ImageIcon("monkey.png");
            monkeyX = 368;
            monkeyY = 20;
            
            monkeyTimer = new Timer();
            timerTask = new TimerTask(){
    			public void run() {
    				if(monkeyY < 630) {
    					monkeyY+=19;
    				}else {
    					gameOver = true;
    				}
    				repaint();
    			}
            };
            
            monkeyTimer.schedule(timerTask,1000, 1000);
    	}
        monkeyDead = new ImageIcon("monkey dead.png");
        lava = new ImageIcon("ground.gif");
        lavaX = 5;
        lavaY = 680;
        rope = new ImageIcon("rope short.png");
        ropeX = 100;
        ropeY = 6;
        mountain = new ImageIcon("volcano.jpg");
        mountainX = 0;
        mountainY = 0;
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));

    }
    
    public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.drawImage(mountain.getImage(), mountainX, mountainY, this);
    	g.drawImage(lava.getImage(), lavaX, lavaY, this);
    	g.drawImage(rope.getImage(), ropeX, ropeY, this);
    	
    	
    	if(!gameOver) {
        	g.drawImage(monkey.getImage(), monkeyX, monkeyY, this);
    	}else {
        	g.drawImage(monkeyDead.getImage(), monkeyX, monkeyY, this);
    	}
    	g.drawString(" "+ monkeyY, 40, 40);
		
	}

    public static void dropMonkeyY(){
    	if(!gameOver) {
    		monkeyY += 100;
    	}
    }
    public static void raiseMonkeyY() {
    	if(!gameOver) {
    		if(monkeyY < 5) {
    			monkeyY = 0;
    		}else {
        		monkeyY -= 30;
    		}
    	}
    }
}