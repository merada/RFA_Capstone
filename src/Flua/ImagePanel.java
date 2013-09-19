package Flua;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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




