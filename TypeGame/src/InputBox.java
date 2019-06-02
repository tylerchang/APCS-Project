import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InputBox extends JPanel{
	
	JTextField textField;
	
	
	public InputBox() {
		textField = new JTextField(14);
		textField.addKeyListener(new EnterKeyListener());
		
		this.setPreferredSize(new Dimension(355,55));
		this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        textField.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        this.add(textField);
    }
	
	public static void playSound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e){
			
		}
	}

       
	class EnterKeyListener implements KeyListener{

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				if(textField.getText().equals(TypingPanel.wordsFalling.get(0).getText())){
					TypingPanel.wordsFalling.remove(TypingPanel.wordsFalling.get(0));
					MonkeyPanel.raiseMonkeyY();
					textField.setText("");
					TypingPanel.isWrong = false;
					TypingPanel.wordsTyped++;
				}
				else {
					TypingPanel.isWrong = true;
					playSound(new File("wrongSound.wav"));
				}
				
			}
		}
		public void keyTyped(KeyEvent e) {	
		}
		public void keyReleased(KeyEvent e) {
			
		}
	}
    	
}
