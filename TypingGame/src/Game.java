import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	public static final int WIDTH = 1800;
	public static final int HEIGHT = 900;

	public static void main(String[] args) {
		
		//Frame related
		JFrame frame = new JFrame("Game");
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Components
		JPanel titlePage = new JPanel(new GridBagLayout());
		titlePage.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		titlePage.setBackground(Color.RED);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,40,40);
		
		JLabel titleLabel = new JLabel("Welcome To The Game");
		titleLabel.setPreferredSize(new Dimension(2000, 100));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Gotham", Font.BOLD, 100));
		
		JButton playButton = new JButton("Play");
		playButton.setPreferredSize(new Dimension(2000,2000));
		
		
		MainCanvas mainCanvas = new MainCanvas(WIDTH, HEIGHT);
		mainCanvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		
		
		class PlayListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setContentPane(mainCanvas);
				frame.revalidate();
			}
		}
		playButton.addActionListener(new PlayListener());
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		titlePage.add(titleLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 30;
		titlePage.add(playButton, gbc);
		
		
		frame.add(titlePage);
		frame.setVisible(true);
	}

}
