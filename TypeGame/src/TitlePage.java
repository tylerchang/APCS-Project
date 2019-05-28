import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class TitlePage extends JPanel{
	
	private GridBagConstraints gbc;
	private JLabel titleLabel;
	private JButton playButton;
	private Image background;
	
	public TitlePage() {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(15,15,40,40);
		
		background = new ImageIcon("titleBackground.gif").getImage();
		
		titleLabel = new JLabel("Can You Save The Monkey?");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Gotham", Font.BOLD, 100));
		titleLabel.setForeground(Color.WHITE);
		
		playButton = new JButton("Yes I Can!");
		playButton.setBackground(new Color(102, 0, 153));
		playButton.setOpaque(false);
		playButton.setPreferredSize(new Dimension(350,200));
		playButton.setFont(new Font("Gotham", Font.PLAIN, 60));
		playButton.addActionListener(new PlayListener());
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(titleLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 30;
		this.add(playButton, gbc);
	}

	public void paintComponent(Graphics gr) {
    	Graphics2D g = (Graphics2D) gr;
    	g.drawImage(background, 0,0, this);
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
