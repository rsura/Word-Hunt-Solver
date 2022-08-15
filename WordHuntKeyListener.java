import javax.swing.*;
import java.awt.*;

public class WordHuntKeyListener {
    private final JTextField field;
	private final Component nextComponent;
	private final Component previousComponent;

    public WordHuntKeyListener(Component previousComponent, JTextField field, Component nextComponent){
		this.previousComponent = previousComponent;
		this.field = field;
		this.nextComponent = nextComponent;
	}
}
