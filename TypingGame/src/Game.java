import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Game {
	
	public static final int WIDTH = 1400;
	public static final int HEIGHT = 700;

	public static void main(String[] args) {
		
		//Frame
		JFrame frame = new JFrame("Game");
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gamePanel = new GamePanel(WIDTH,HEIGHT);
		
		//Title Page crap
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
					frame.setContentPane(gamePanel);
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
