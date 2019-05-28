import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class TypingPanel extends JPanel{
	
	private WordBank wordBank;
	private Timer timer;
	private TimerTask timerTask;
	public static ArrayList<Word> wordsFalling;
	private InputBox textInput;
	private Image background;
	private int delay;   
	private JButton button;
	
    public TypingPanel() throws IOException{
    	
    	background = new ImageIcon("rock background.jpg").getImage();
    	
    	timer = new Timer();
    	delay = 1300;
    	textInput = new InputBox();
    	this.add(textInput);
    	timerTask = new TimerTask() {
		public void run() {		
			if(delay > 100) {
				delay -= 70;
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
    	
    	Graphics2D g = (Graphics2D) gr;
    	
    	g.drawImage(background, 0, 0, null);
    	
    	//Getting a random word
    	try {
    		
		wordsFalling.add(wordBank.getWord());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	//Updating the Y coordinates of all existing words
    	if(!MonkeyPanel.gameOver) {
    		for(int i = 0; i<wordsFalling.size(); i++) {
        		Word word = wordsFalling.get(i);
        		
        		if(word.getY() < 120) {
        			wordsFalling.remove(i);
        			MonkeyPanel.dropMonkeyY();
        		}else {
                	word.setY(word.getY()-40);
        		}
        	}	
    	}
    	
    	
    	//Painting the words
    	if(!MonkeyPanel.gameOver) {
    		for(int i = 0; i<wordsFalling.size(); i++) {
        		if(i == 0) {
        			g.setColor(Color.YELLOW);
        	    	g.setFont(new Font("Helvetica", Font.BOLD, 30));
            		g.drawString(wordsFalling.get(i).getText(),wordsFalling.get(i).getX(),wordsFalling.get(i).getY());
        		}
        		else{
        			g.setColor(Color.WHITE);
        	    	g.setFont(new Font("Helvetica", Font.BOLD, 30));
            		g.drawString(wordsFalling.get(i).getText(),wordsFalling.get(i).getX(),wordsFalling.get(i).getY());
        		}
        	}
    	}
    	else {
    		button = new JButton("Start Over");
    		
    		g.setColor(Color.WHITE);
    		g.setFont(new Font("Gotham", Font.BOLD, 100));
    		g.drawString("Game Over", 120, 500);
    		g.setFont(new Font("Gotham", Font.PLAIN, 20));
    		g.drawString("A life was lost today. You couldn't save the monkey and now it's dead.", 70, 550);
    		this.add(button);
    	}
    	
    	    	
    	
    	
    }
  
    	
    	
    	
    }
   
