import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ClickBait2 {
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final int DELAY = 1000;
	

	public static void main(String[] args) {
		JFrame frame = new JFrame("THIS IS THE FRAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ClickBait2Canvas canvas = new ClickBait2Canvas(WIDTH, HEIGHT);
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(canvas);
		frame.pack();
		
		
		class CB2KeyListener implements KeyListener{

			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'r') {
					canvas.resetScore();
				}
				
			}

			public void keyReleased(KeyEvent e) {
				
			}

			public void keyTyped(KeyEvent e) {
				
			}
			
		}
		
		canvas.addKeyListener(new CB2KeyListener());
		canvas.setFocusable(true);
		canvas.requestFocus();
		
		class TimerListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				canvas.moveImage();
			}
		}
		
		Timer t = new Timer(DELAY, new TimerListener());
		t.start();
		
		class CBMouseListener implements MouseListener{

			
			public void mouseClicked(MouseEvent e) {
				
			}

			
			public void mouseEntered(MouseEvent e) {
				
			}

			
			public void mouseExited(MouseEvent e) {
				
			}

			
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				canvas.checkClick(x,y);
			}

			
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		}
		canvas.addMouseListener(new CBMouseListener());
		frame.setVisible(true);
		
	}
	
	
}
