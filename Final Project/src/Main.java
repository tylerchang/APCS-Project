import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	
	private static int count = 0;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(300,300));
		JButton inc = new JButton("increment");
		JLabel label = new JLabel("Count: " + count);
		
		class IncListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				label.setText("Count: " + count);
				
			}
			
		}
		
		inc.addActionListener(new IncListener());
		
		JButton dec = new JButton("decrement");
	
		
		class DecListener implements ActionListener{
			public void actionPerformed (ActionEvent e){
				count--;
				label.setText("Count: " + count);
			}
		}
		
		dec.addActionListener(new DecListener());
		
		
		JButton resetCount = new JButton("Reset");
		
		class ResetListener implements ActionListener{
			public void actionPerformed (ActionEvent e) {
				count = 0;
				label.setText("Count: "+ count);
				System.out.println(e);
			}
		}
		resetCount.addActionListener(new ResetListener());
		
		JPanel panel = new JPanel();
		panel.add(dec);
		panel.add(label);
		panel.add(inc);
		panel.add(resetCount);
		
		//to add a menu
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("File");
		
		JMenuItem item = new JMenuItem("Do Something");		
		
		class MenuListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		}
		
		item.addActionListener(new MenuListener());
		menu.add(item);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		int boxWidth = 10;
		JTextField in = new JTextField(boxWidth);
		
		class InputListener implements ActionListener{
			
			public void actionPerformed(ActionEvent arg0) {
				label.setText(in.getText());
				in.setText("");
			}
		}
		in.addActionListener(new InputListener());
		
		JTextArea textArea = new JTextArea(4,10);
	
		
		panel.add(textArea);
		
		panel.add(in);
		
		frame.add(panel);
		
		
		
		frame.setVisible(true);
	}


}
