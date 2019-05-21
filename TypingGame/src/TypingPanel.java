import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TypingPanel extends JPanel{
    private final int WIDTH;
    private final int HEIGHT;

    public TypingPanel(int width, int height){
        WIDTH = width;
        HEIGHT = height;
         this.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label = new JLabel("typing SIde");
        this.add(label);
    }
}