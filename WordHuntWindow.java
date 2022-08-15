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
    private List<JTextField> characters = new ArrayList<>(16);
	private JButton solve = new JButton("Solve!");
	private JTextArea words;
}
