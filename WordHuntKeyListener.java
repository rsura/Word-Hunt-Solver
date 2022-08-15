import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordHuntKeyListener implements KeyListener {
    private final JTextField field;
	private final Component nextComponent;
	private final Component previousComponent;

    public WordHuntKeyListener(Component previousComponent, JTextField field, Component nextComponent){
		this.previousComponent = previousComponent;
		this.field = field;
		this.nextComponent = nextComponent;
	}

    @Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_TAB || e.getKeyChar() == KeyEvent.VK_ENTER){
			nextComponent.requestFocus();
		} else if (e.getKeyChar() == KeyEvent.VK_TAB && e.isShiftDown()) {
			previousComponent.requestFocus();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
