package Flua;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Create a Label with specific dimensions and display settings
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
class Label extends JLabel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construct a label with a specific message
	 * @param title Text to display on the label
	 */
	public Label(String message) {
		super(message, SwingConstants.CENTER);
		setOpaque(false);
		
		setFont(Driver.fontManager.getFont());
	}
}