import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	public static final int WIDTH = 2000;
	public static final int HEIGHT = 900;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Game");
		JPanel titlePage = new JPanel();
		JLabel titleLabel = new JLabel("Welcome To The Game");
		JButton playButton = new JButton("Play");
		playButton.setPreferredSize(new Dimension(400,40));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		class PlayListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MainCanvas mainCanvas = new MainCanvas(WIDTH, HEIGHT);
				mainCanvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
				titlePage.add(mainCanvas);
			}
			
		}
		playButton.addActionListener(new PlayListener());
		
		titlePage.add(titleLabel);
		titlePage.add(playButton);
		
		
		frame.add(titlePage);
		frame.setVisible(true);
	}

}
