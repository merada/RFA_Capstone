package Flua;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * Panel to hold word hints. Hints implemented as interactive widgets.
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
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
	 * Random number generator used to extract random words from the list 
	 */
	private Random random;
	
	/**
	 * Array to hold the indices of the randomly chosen words
	 */
	private int[] indices;
	
	/**
	 * 
	 * @param i InputHandler to handle user input
	 */
	public WordPanel(InputHandler i) {
		inputHandler = i;
		random = new Random(System.nanoTime()); // seed so that new words are chosen every time
		indices = new int [5]; // allow 5 hint words
		
		extractWords();
		chooseRandomWords();

		initialize();
	}
	
	/**
	 * Initialize the GUI aspects of the WordPanel (complete with layout)
	 */
	public void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(255, 390));
		
		SpringLayout mng = new SpringLayout();
		
		JPanel anchor = new JPanel(); // to place other components relatively
		anchor.setOpaque(false);
		
		// buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension (140, 300));
		buttonPanel.setLayout(new FlowLayout());
		
		for (int i = 0; i < indices.length; i++)
			buttonPanel.add(new Button(words.get(indices[i]), "Word " + words.get(indices[i]), inputHandler, true));
				
		mng.putConstraint(SpringLayout.WEST, buttonPanel, 50, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, buttonPanel, 60, SpringLayout.SOUTH, anchor);

		// help text label
		// use html to wrap message within label
		Label helpLabel = new Label("<html>Click on a word to<br>add it to your answer<html>");
		
		mng.putConstraint(SpringLayout.WEST, helpLabel, 10, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, helpLabel, 310, SpringLayout.SOUTH, anchor);
		
		// set layout for Panel
		setLayout(mng);
		
		add(anchor);
		add(buttonPanel);
		add(helpLabel);
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
	
	/**
	 * Choose random indices of words to display in this game
	 */
	public void chooseRandomWords() {
		for (int i = 0; i < indices.length; i++) {
			int newRandomWordIndex = random.nextInt(words.size());
			indices[i] = newRandomWordIndex;
			System.out.print(indices[i] + " ");
		}
	}
}
