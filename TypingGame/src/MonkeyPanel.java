import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MonkeyPanel extends JPanel{
    private final int WIDTH;
    private final int HEIGHT;

    public MonkeyPanel(int width, int height){
        WIDTH = width;
        HEIGHT = height;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label = new JLabel("Monkey SIde");
        this.add(label);
    }
}