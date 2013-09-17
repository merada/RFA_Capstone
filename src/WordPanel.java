/**
 * Panel to hold word hints. Hints implemented as interactive widgets.
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

	/**
	 * auto-generated serialVersionUID
	 */
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
