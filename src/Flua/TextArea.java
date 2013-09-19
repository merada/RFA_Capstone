package Flua;

import javax.swing.JTextArea;

/**
 * Create a TextArea with specific dimensions and display settings
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
class TextArea extends JTextArea {
	
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Hard-coded dimensions; originX, originY, width, height
	 */
	private int [] book_left = {50, 40, 300, 300};
	
	/**
	 * Hard-coded dimensions; originX, originY, width, height
	 */
	private int [] book_right = {385, 40, 300, 300};
	
	/**
	 * Hard-coded dimensions; originX, originY, width, height
	 */
	private int [] menu = {50, 50, 100, 100};
	
	public TextArea(String text, String type) {
		super(text);
		setOpaque(false);
		setLineWrap(true);
		setWrapStyleWord(true);
		setFont(Driver.fontManager.getFont());
		
		switch (type) {
		case "book_left":
			setBounds(book_left[0], book_left[1], book_left[2], book_left[3]);
			break;
		case "book_right":
			setBounds(book_right[0], book_right[1], book_right[2], book_right[3]);
			break;
		case "menu":
			setBounds(menu[0], menu[1], menu[2], menu[3]);
			break;	
		default:
			break;
		}
	}
}