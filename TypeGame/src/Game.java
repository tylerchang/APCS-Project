import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class Game {
	
	public static int WIDTH;
	public static int HEIGHT;
	private static JFrame frame;
	private static GamePanel gamePanel;

	public static void main(String[] args) throws IOException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = (int) screenSize.getWidth();
		HEIGHT = (int) screenSize.getHeight();
		
		//Frame
		frame = new JFrame("Game");
		frame.setSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TitlePage titlePage = new TitlePage();		
		frame.add(titlePage);
		frame.setVisible(true);
		TitlePage.playIntroMusic(new File("inspoMusic.wav"));

	}
	
	public static void startGame() throws IOException {
		gamePanel = new GamePanel(WIDTH,HEIGHT);
		frame.setContentPane(gamePanel);
		frame.revalidate();
	}

}
