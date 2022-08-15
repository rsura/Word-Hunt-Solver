import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class WordHuntDocListener implements DocumentListener{
    private final JTextField field;
	private final Component nextComponent;
	private final Component previousComponent;

    public WordHuntDocListener(Component previousComponent, JTextField field, Component nextComponent){
		this.previousComponent = previousComponent;
		this.field = field;
		this.nextComponent = nextComponent;
	}

    @Override
	public void insertUpdate(DocumentEvent e) {
		Document document = e.getDocument();
		try {
			String currText = document.getText(0,document.getLength());
			if (currText.matches("[a-zA-Z]+")){
				if (currText.length() > 1){
					field.requestFocus();
				} else {
					nextComponent.requestFocus();
				}
				nextComponent.requestFocus();
			} else {
				field.requestFocus();
			}
		} catch (Exception ignored) {}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			field.setText(e.getDocument().getText(0,1));
		} catch (Exception ignored) {}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {

	}
}
