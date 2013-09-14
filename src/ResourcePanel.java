/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;


public class ResourcePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private InputHandler inputHandler;
	
	private String imageFilename = null;
	private ArrayList<String> textLeft = null;
	private ArrayList<String> textRight = null;
	
	private ImagePanel imagePanel = null;
	private TextArea textAreaLeft = null;
	private TextArea textAreaRight = null;
	
	
	public ResourcePanel(InputHandler i, String filename) {
		inputHandler = i;
		
		extractResources(filename);
		
		initialize();
	}
	
	
	public void initialize() {
		setPreferredSize(new Dimension(740, 385));
		setOpaque(false);

		imagePanel = new ImagePanel(imageFilename);
		
		if (!textLeft.isEmpty()) {
			textAreaLeft = new TextArea(textLeft.get(0), "book_left");
			imagePanel.add(textAreaLeft);
			textAreaRight = new TextArea(textRight.get(0), "book_right");
			imagePanel.add(textAreaRight);
		}
		
		setLayout(new BorderLayout());
		add(imagePanel, BorderLayout.WEST);
	}
	
	
	public void turnPage() {
		// TODO
	}
	
	
	
	// use a switch statement to assign text resources to correct data structure
	// eg book text goes one way, input text to fill in goes another way
	public void extractResources(String filename) {
		Scanner input_stream = null;
		
		textLeft = new ArrayList<String> ();
		textRight = new ArrayList<String> ();
		
		try {
			input_stream = new Scanner (new FileInputStream(filename));
		} catch (Exception e) {
			System.out.println("Error: file "+filename+" not found.");
			System.exit(0);
		}
		
		imageFilename = input_stream.nextLine();
		while (input_stream.hasNextLine()) {
			textLeft.add(input_stream.nextLine());
			textRight.add(input_stream.nextLine());
		}
	}
}
