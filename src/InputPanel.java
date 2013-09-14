/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class InputPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private InputHandler inputHandler;
	
	
	public InputPanel(InputHandler i) {
		inputHandler = i;

		initialize();
	}
	
	
	public void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(740, 390));
	}
	
}
