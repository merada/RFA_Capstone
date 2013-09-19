package Flua;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

/**
 * Create a panel to hold the resources required for the game
 * 
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class ResourcePanel extends JPanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * Name of file holding background image to be assigned to this ResourcePanel
	 */
	private String imageFilename = null;
	
	/**
	 * List holding the text to be displayed on the left of centre
	 */
	private ArrayList<String> textLeft = null;
	
	/**
	 * List holding the text to be displayed on the right of centre
	 */
	private ArrayList<String> textRight = null;
	
	/**
	 * Background image of this ResourcePanel
	 */
	private ImagePanel imagePanel = null;
	
	/**
	 * Text area left of centre
	 */
	private TextArea textAreaLeft = null;
	
	/**
	 * Text area right of centre
	 */
	private TextArea textAreaRight = null;
	
	/**
	 * Create a resource panel to hold resources for the current game
	 * @param i InputHandler to handle user input
	 * @param filename Name of file holding resource details for the game
	 */
	public ResourcePanel(InputHandler i, String filename) {
		inputHandler = i;
		
		extractResources(filename);
		
		initialize();
	}
	
	/**
	 * Initialize the GUI aspects of the ResourcePanel (complete with layout)
	 */
	public void initialize() {
		setPreferredSize(new Dimension(740, 385));
		setOpaque(false);

		imagePanel = new ImagePanel(imageFilename);
		
		if (!textLeft.isEmpty()) {
			textAreaLeft = new TextArea(textLeft.get(0), "book_left");
			textAreaLeft.setEditable(false);
			imagePanel.add(textAreaLeft);
			textAreaRight = new TextArea(textRight.get(0), "book_right");
			textAreaRight.setEditable(false);
			imagePanel.add(textAreaRight);
		}
		
		setLayout(new BorderLayout());
		add(imagePanel, BorderLayout.WEST);
	}
	
	/**
	 * Extract game resources, assigning text resources to correct data structure (e.g. book text goes one way, input text to fill in goes another way)
	 * @param filename Name of file holding resource details for the game
	 */
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
