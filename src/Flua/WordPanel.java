package Flua;
/**
 * Panel to hold word hints. Hints implemented as interactive widgets.
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class WordPanel extends JPanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * File holding the resources for the WordPanel (collection of words a learner can use when playing a game)
	 */
	private String filename = "./games/words.txt";
	
	/**
	 * Array holding possible words to be used in the tray 
	 */
	private ArrayList<String> words;
	
	/**
	 * 
	 * @param i InputHandler to handle user input
	 */
	public WordPanel(InputHandler i) {
		inputHandler = i;
		
		extractWords();

		initialize();
	}
	
	/**
	 * Initialize the GUI aspects of the WordPanel (complete with layout)
	 */
	public void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(255, 390));
		
		// choose random words to display
		// make them interactive
	}
	
	/**
	 * Extract words from a given file and add them to an ArrayList
	 */
	public void extractWords() {
		Scanner input_stream = null;
		
		words = new ArrayList<String>();
		
		try {
			input_stream = new Scanner (new FileInputStream(filename));
			
			while (input_stream.hasNextLine()) {
				words.add(input_stream.nextLine());
			}
		} catch (Exception e) {
			System.out.println("Error: file "+filename+" not found.");
			System.exit(0);
		}
	}
}
