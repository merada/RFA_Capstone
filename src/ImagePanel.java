import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
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
 * Create a TextArea which 
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
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
 * @date 2013.09.17
 */
class Button extends JButton {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	public Button(String title, String command, InputHandler inputHandler) {
		super(title);
		setActionCommand(command);
		addActionListener(inputHandler);
		
		setFont(Driver.fontManager.getFont());
		
	}
}
