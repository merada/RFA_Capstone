/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class ImagePanel extends JPanel {
	
	private Image backgroundImage;
	
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
    }
	
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


class TextArea extends JTextArea {
	
	// hardcoded dimensions; originX, originY, width, height
	private int [] book_left = {50, 40, 300, 300};
	private int [] book_right = {385, 40, 300, 300};
	private int [] menu = {50, 50, 100, 100};
	
	public TextArea(String text, String type) {
		super(text);
		setOpaque(false);
		setLineWrap(true);
		setWrapStyleWord(true);
		
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
