import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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
	public static Timer wordTimer;
	private TimerTask timerTask;
	public static Timer survivalTimer;
	private TimerTask survivalTimerTask;
	public static ArrayList<Word> wordsFalling;
	private InputBox textInput;
	private Image background;
	private int delay;   
	private JButton button;
	public static boolean isWrong;
	public static int wordsTyped;
	private int secondsSurvived;
	private SurvivalTime survivalTime;
	
	
    public TypingPanel() throws IOException{
    	
    	background = new ImageIcon("black rock.jpg").getImage();
    	isWrong = false;
    	
    	if(!MonkeyPanel.gameOver) {
    		secondsSurvived = 0;
    		wordsTyped = 0;
    		wordsTyped = 0;
	    	wordsFalling = new ArrayList<Word>();
	    	wordBank = new WordBank();
	    	survivalTimer = new Timer();
	    	survivalTimerTask = new TimerTask() {
				@Override
				public void run() {
					secondsSurvived++;
				}		
	    	};
	    	
	    	wordTimer = new Timer();
	    	delay = 1225;
	    	textInput = new InputBox();
	    	this.add(textInput);

	    	timerTask = new TimerTask() {
			public void run() {		
				if(delay > 100) {
					delay -= 40;
				}
				repaint();
				}
	    	};
	        this.setBorder(BorderFactory.createLineBorder(Color.black));
	        survivalTimer.schedule(survivalTimerTask, 0,1000);
	        wordTimer.schedule(timerTask, 1000, delay);
	        
    	}
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
    		g.setColor(Color.white);
    
    		
    		for(int i = 0; i<wordsFalling.size(); i++) {
        		if(i == 0) {
        			if(isWrong) {
        				g.setColor(Color.RED);
            	    	g.setFont(new Font("Helvetica", Font.BOLD, 30));
                		g.drawString(wordsFalling.get(i).getText(),wordsFalling.get(i).getX(),wordsFalling.get(i).getY());
        			}else {
        				g.setColor(Color.YELLOW);
            	    	g.setFont(new Font("Helvetica", Font.BOLD, 30));
                		g.drawString(wordsFalling.get(i).getText(),wordsFalling.get(i).getX(),wordsFalling.get(i).getY());
        			}
        			
        		}
        		else{
        			g.setColor(Color.WHITE);
        	    	g.setFont(new Font("Helvetica", Font.BOLD, 30));
            		g.drawString(wordsFalling.get(i).getText(),wordsFalling.get(i).getX(),wordsFalling.get(i).getY());
        		}
        	}
    	}
    	else {
			TypingPanel.survivalTimer.cancel();
    		survivalTime = new SurvivalTime(secondsSurvived);

    		
    		this.addMouseListener(new StartOverListener());
    		g.setColor(Color.WHITE);
    		g.setFont(new Font("Gotham", Font.BOLD, 100));
    		g.drawString("Game Over", 120, 200);
    		
    		g.setFont(new Font("Gotham", Font.BOLD, 30));
    		if(survivalTime.getMinutes()>=1) {
    			if(survivalTime.getMinutes()==1) {
        			g.drawString("The monkey survived for " + survivalTime.getMinutes() + " minute and " + survivalTime.getSecondsLeft() + " seconds.", 20, 300);
    			}
    			else {
        			g.drawString("The monkey survived for " + survivalTime.getMinutes() + " minutes and " + survivalTime.getSecondsLeft() + " seconds.", 20, 300);
    			}
    		}else {
    			g.drawString("The monkey survived for " + survivalTime.getSeconds() + " seconds", 130, 300);
    		}
    		
    		g.setFont(new Font("Gotham", Font.BOLD, 23));
    		
    		
    		double speed = ((double)wordsTyped)/survivalTime.getFullMinutes();
    		
    		g.drawString("Congrats! You typed " + wordsTyped + " words at a speed of " + Math.round(speed*1000)/1000.0 + " WPM.", 100 , 400);
    		
    		
    		
    		
    		g.setFont(new Font("Gotham", Font.PLAIN, 20));
    		g.drawString("Unfortunately, that was not enough to save the monkey. " + "A life was lost today.", 45, 530);
    		g.setFont(new Font("Gotham", Font.BOLD, 50));
    		g.setColor(Color.gray);
    		g.fillRect(165, 600, 500, 70);
    		g.setFont(new Font("Gotham", Font.BOLD, 50));
    		g.setColor(Color.WHITE);
    		g.drawString("try again...", 280, 650);

    	
    	}
    	  	
    }
  
    public static boolean checkClick(int x, int y) {
    	if(x>=165 && x<=165+500 && y>=600 && y<=600+70) {
    		return true;
    	}
    	return false;
    }
    
    
}

class StartOverListener implements MouseListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(TypingPanel.checkClick(x,y)) {
			MonkeyPanel.gameOver = false;
			MonkeyPanel.monkeyTimer.cancel();
			TypingPanel.wordTimer.cancel();
			try {
				Game.startGame();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}




   
