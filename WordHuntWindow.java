import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    /**
     * GUI Constructor to display the window.
     */
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

        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

        int[] xCoords = {50,100,150,200};
		int[] yCoords = {50,100,150,200};
		for (int i = 0; i < 16; i++) {
			JTextField textField = new JTextField(1);
			textField.setBounds(xCoords[i % 4], yCoords[i / 4],40,40);
			textField.setBackground(new Color(0xD3D385));
			textField.setFont(new Font("DIALOG", Font.BOLD, 20));
			textField.setVisible(true);
			textField.setFocusable(true);
			textField.setHorizontalAlignment(JTextField.CENTER);
			textField.addActionListener(e -> e.setSource(textField));
			characters.add(textField);
			add(textField);
		}
        
        solve.setBounds(50,300,190,60);
		solve.setFocusable(true);
		solve.setFont(new Font("Default",Font.BOLD,20));

        add(solve);

        ScrollPane scrollPane = new ScrollPane();
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.setVisible(true);
		scrollPane.setBounds(290,50,160,350);
		scrollPane.setBackground(Color.LIGHT_GRAY);

		words = new JTextArea("");
		words.setEditable(false);
		words.setFont(new Font("Default",Font.PLAIN,15));
		words.setBorder(BorderFactory.createCompoundBorder(
				words.getBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		words.setAutoscrolls(true);
		scrollPane.add(words);
		add(scrollPane);
		characters.get(0).requestFocus();

        // Next 2 lines for "window refreshing" if some fields don't show up at first
        setSize(501,501);
		setSize(500,500);
    }

    public static void main(String[] args){
        new WordHuntWindow(); // to run the window
    }
}
