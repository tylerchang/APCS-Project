import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class TitlePage extends JPanel{
	
	private GridBagConstraints gbc;
	private JLabel titleLabel;
	private JButton playButton;
	private Image background;
	private JLabel name;
	
	public TitlePage() {
	
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,15,15);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.weightx = 0.2;
		gbc.weighty = 0.05;
		background = new ImageIcon("titleBackground.gif").getImage();
		
		name = new JLabel("Tyler Chang 2019");
		name.setHorizontalAlignment(JLabel.CENTER);
		name.setVerticalAlignment(JLabel.CENTER);
		name.setFont(new Font("Gotham", Font.BOLD, 20));
		name.setForeground(Color.WHITE);
		
		titleLabel = new JLabel("Monkey Saver");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Gotham", Font.BOLD, 100));
		titleLabel.setForeground(Color.WHITE);
		
		playButton = new JButton("Play");
		playButton.setBackground(new Color(255, 77, 77));
		playButton.setOpaque(true);
		playButton.setBorderPainted(false);
		playButton.setPreferredSize(new Dimension(350,120));
		playButton.setFont(new Font("Gotham", Font.BOLD, 65));
		playButton.setForeground(Color.WHITE);
		playButton.addActionListener(new PlayListener());
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(name,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(titleLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(playButton, gbc);

	}

	public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.drawImage(background, 0,0, this);
	}
	
	public static void playIntroMusic(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e){
			
		}
	}
}

class PlayListener implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		try {
			Game.startGame();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

