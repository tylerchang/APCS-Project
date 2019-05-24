import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import java.util.Timer;


public class TypingPanel extends JComponent{
	
	private WordBank wordBank;
	private Timer timer;
	private TimerTask timerTask;

   
    public TypingPanel() throws IOException{
    	timer = new Timer();
    	
    	timerTask = new TimerTask() {
			public void run() {
				repaint();
			}		
    	};
    	
    	wordBank = new WordBank();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        timer.schedule(timerTask, 1000, 1000);
    }
    
    public void paintComponent(Graphics gr) {
    	super.paintComponent(gr);
    	
    	Word word = new Word("LOL");
    	try {
			word = wordBank.getWord();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Graphics2D g = (Graphics2D) gr;
    	g.drawString(word.getText(), word.getX(), word.getY());
    	
    }
    public void update(Graphics g) {
    	paint(g);
    }


	
}