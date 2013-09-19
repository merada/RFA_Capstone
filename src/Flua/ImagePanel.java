package Flua;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Wrapper class to create a panel with its background set to an image
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
class ImagePanel extends JPanel {
	
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	
	/**
	 * Constructs an ImagePanel showing the image from the filename in the parameter
	 * @param img Filename of the image to be displayed
	 */
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
    }
	
	/**
	 * Constructs an ImagePanel showing the Image from the parameter
	 * @param img Image to be displayed
	 */
	public ImagePanel(Image img) {
		this.backgroundImage = img;
		Dimension size = new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}
}

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