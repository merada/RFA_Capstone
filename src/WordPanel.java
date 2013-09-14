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


public class WordPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private InputHandler inputHandler;
	
	public WordPanel(InputHandler i) {
		inputHandler = i;

		initialize();
	}
	
	public void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(255, 390));
	}
}
