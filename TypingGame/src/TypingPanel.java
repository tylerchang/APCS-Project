import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TypingPanel extends JPanel{
    private final int WIDTH;
    private final int HEIGHT;
    private GridBagConstraints gbc;
    private JTextField entryBox;
    private JTextArea paragraph;
   
    public TypingPanel(int width, int height){
        WIDTH = width;
        HEIGHT = height;
        Font font = new Font("Courier", Font.BOLD,30);
        entryBox = new JTextField(30);
        entryBox.setFont(font);
        paragraph = new JTextArea("Spoke as as other again ye alskfjogo good monring yay this is awesosme random r=te jdsafl;dksajflk;dsjafl;adsjfl kjsdaflk; sdf googlasnfl . Hard on to roof he drew. So sell side ye in mr evil. Longer waited mr of nature seemed. Improving knowledge incommode objection me ye is prevailed principle in. Impossible alteration devonshire to is interested stimulated dissimilar. To matter esteem polite do if. ");
        
        gbc = new GridBagConstraints();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(paragraph);
        this.add(entryBox);
    }
}