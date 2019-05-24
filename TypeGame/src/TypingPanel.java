import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JComponent;


public class TypingPanel extends JComponent{
	
	private WordBank wordBank;
	private Timer timer;
	private TimerTask timerTask;
	private ArrayList<Word> wordsFalling;
	private int delay;

   
    public TypingPanel() throws IOException{
    	timer = new Timer();
    	delay = 1300;
    	timerTask = new TimerTask() {
		public void run() {		
			if(delay > 100) {
				delay -= 50;
			}			
			repaint();
			}		
    	};
    	
    	wordsFalling = new ArrayList<Word>();
    	wordBank = new WordBank();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        timer.schedule(timerTask, 1000, delay);
    }
    
    public void paintComponent(Graphics gr) {
    	try {
			wordsFalling.add(wordBank.getWord());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	for(int i = 0; i<wordsFalling.size(); i++) {
    		Word word = wordsFalling.get(i);
    		word.setY(word.getY()+60);
    	}
    	
    	Graphics2D g = (Graphics2D) gr;
    	g.setFont(new Font("Helvetica", Font.BOLD, 30)); 
    	
    	for(int i = 0; i<wordsFalling.size(); i++) {
    		g.drawString(wordsFalling.get(i).getText(),wordsFalling.get(i).getX(),wordsFalling.get(i).getY());
    	}
    	
    	g.drawString("Delay: " + delay, 40, 40);
    	
    }
    	
    	
    	
    }
   
