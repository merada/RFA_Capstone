package Flua;

import java.awt.Color;

import javax.swing.JButton;

/**
 * Creates specialized buttons in the theme of the program by setting size, background and font.
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
class Button extends JButton {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Construct a button complete with label, action-command and links to the user input handler
	 * @param title Text to display on the button
	 * @param command Action-command to be assigned to the button
	 * @param inputHandler Handler to respond to user interaction
	 */
	public Button(String title, String command, InputHandler inputHandler) {
		super(title);
		setActionCommand(command);
		addActionListener(inputHandler);
		
		setFont(Driver.fontManager.getFont());
	}
	
	/**
	 * Construct a WordPanel button complete with label, action-command and links to the user input handler
	 * @param title Text to display on the button
	 * @param command Action-command to be assigned to the button
	 * @param inputHandler Handler to respond to user interaction
	 * @param b Used to differentiate between WordPanel buttons and other buttons
	 */
	public Button(String title, String command, InputHandler inputHandler, boolean b) {
		super(title);
		setActionCommand(command);
		addActionListener(inputHandler);
		
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		
		setFont(Driver.fontManager.getFont());
	}
}