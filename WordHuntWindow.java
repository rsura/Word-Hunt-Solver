import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the GUI version of the Word Hunt Solver class. Has a
 * non-resizable window with defined character outputs to look
 * like the grid in the game, with a word list on the side.
 * 
 * @author  Rahul Sura
 */
public class WordHuntWindow extends Frame{
    // All the text fields of characters in an ArrayList
    private List<JTextField> characters = new ArrayList<>(16);

    // Solve button
	private JButton solve = new JButton("Solve!");

    // Possible words
	private JTextArea words;

    public WordHuntWindow(){
        setBackground(new Color(0x5BAF5B));
		setTitle("Word Hunt Solver");
		setSize(500,500);
		setMinimumSize(new Dimension(500,500));
		setAlwaysOnTop(true);
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
		setLayout(null);
		setVisible(true);
		setFocusable(true);
		setLocationRelativeTo(null);
		setResizable(false);
    }

    public static void main(String[] args){
        new WordHuntWindow();
    }
}
