package Flua;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * Parent panel to initialize and manage individual game panels
 * (namely the Control, Word, Resource and Input panels).
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class GamePanel extends JPanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * Background image of the game
	 */
	private Image backgroundImage = null;
	
	/**
	 * One of 4 panels that make up the basic game screen. Each panel having its own unique functionality: game controls, word hints, game resources and user input
	 */
	private ControlPanel controlPanel;

	/**
	 * One of 4 panels that make up the basic game screen. Each panel having its own unique functionality: game controls, word hints, game resources and user input
	 */
	private WordPanel wordPanel;
	
	/**
	 * One of 4 panels that make up the basic game screen. Each panel having its own unique functionality: game controls, word hints, game resources and user input
	 */
	private ResourcePanel resourcePanel;

	/**
	 * One of 4 panels that make up the basic game screen. Each panel having its own unique functionality: game controls, word hints, game resources and user input
	 */
	private InputPanel inputPanel;
	
	/**
	 * Constructor to create a new Game
	 * @param i InputHandler to handle user input
	 * @param filename name of file holding resource details for the game
	 */
	public GamePanel(String gameTitle, InputHandler i, String filename) {
		inputHandler = i;
		backgroundImage = new ImageIcon("./imgs/bg_game.jpg").getImage();
		
		initialize(gameTitle, filename);
	}
	
	/**
	 * Initialize the GUI aspects of the GamePanel (complete with layout)
	 * @param filename name of file holding resource details for the game
	 */
	public void initialize(String gameTitle, String filename) {
		setOpaque(true);
		
		resourcePanel = new ResourcePanel(inputHandler, filename + "resource.txt");
		controlPanel = new ControlPanel(inputHandler, gameTitle);
		inputPanel = new InputPanel(inputHandler, filename + "input.txt");
		wordPanel = new WordPanel(inputHandler);

		SpringLayout mng = new SpringLayout();
		mng.putConstraint(SpringLayout.WEST, controlPanel, 1, SpringLayout.EAST, resourcePanel);
		mng.putConstraint(SpringLayout.WEST, wordPanel, 1, SpringLayout.EAST, inputPanel);
		mng.putConstraint(SpringLayout.NORTH, inputPanel, 1, SpringLayout.SOUTH, resourcePanel);
		mng.putConstraint(SpringLayout.NORTH, wordPanel, 1, SpringLayout.SOUTH, controlPanel);
		setLayout(mng);
		
		add(resourcePanel);
		add(controlPanel);	
		add(inputPanel);	
		add(wordPanel);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, backgroundImage.getWidth(null), backgroundImage.getHeight(null), null);
	}
	
	/**
	 * Display word in InputTray
	 * @param word Word to display
	 */
	public void addWordToInput(String word) {
		inputPanel.addWord(word);
	}
	
	/**
	 * Accept current answer as valid
	 */
	public void acceptAnswer() {
		inputPanel.acceptAnswer();
	}
	
	/**
	 * Change to next question
	 */
	public void nextQuestion() {
		inputPanel.nextQuestion();
	}
	
	/**
	 * Change to previous question
	 */
	public void previousQuestion() {
		inputPanel.previousQuestion();
	}

	/**
	 * Choose new random words for the WordTray
	 */
	public void chooseNewWords() {
		wordPanel.chooseRandomWords();
	}
}
