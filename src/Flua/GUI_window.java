package Flua;

import javax.swing.JFrame;

/**
 * Manages GUI components
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class GUI_window extends JFrame {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * Panel containing game functionality
	 */
	private GamePanel gamePanel;
	
	/**
	 * Panel containing menu functionality
	 */
	private MenuPanel menuPanel;
	
	/**
	 * List of files containing resources for games
	 */
	private String [] fill_game_filenames = {"fill_0.txt","fill_1.txt","fill_2.txt"};

	/**
	 * List of files containing resources for games
	 */
	private String [] comp_game_filenames = {"comp_test.txt"};
	
	/**
	 * Index to keep track of which resources have been used during the current session
	 */
	private int fill_game_index;

	/**
	 * Index to keep track of which resources have been used during the current session
	 */
	private int comp_game_index;
	
	/**
	 * Default constructor
	 */
	public GUI_window() {
		inputHandler = new InputHandler(this);
		initialize();
		
		fill_game_index = 0;
		comp_game_index = 0;
	}
	
	/**
	 * Initialize the basic parameters for the GUI
	 */
	private void initialize() {
		setTitle("FLUA");
		setSize(1000, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuPanel = new MenuPanel(inputHandler);
		add(menuPanel);
	}
	
	/**
	 * Create a new GamePanel of the type of Game specified in the parameter
	 * @param game The game type to be started (Fill-a-Word or Comprehension)
	 */
	public void startGame(Game game) {
		if (game.getTitle().equals("Fill-a-Word")) {
			if (fill_game_index >= fill_game_filenames.length) // check to make sure we never go out of bounds
				fill_game_index = 0; // reset index
			gamePanel = new FillWordGamePanel(inputHandler, "./games/" + fill_game_filenames[fill_game_index++]);
			menuPanel.setVisible(false);
			add(gamePanel);
		}
		else if (game.getTitle().equals("Comprehension")) {
			if (comp_game_index >= comp_game_filenames.length) // check to make sure we never go out of bounds
				comp_game_index = 0; // reset index
			gamePanel = new ComprehensionGamePanel(inputHandler, "./games/" +  comp_game_filenames[comp_game_index++]);
			menuPanel.setVisible(false);
			add(gamePanel);
		}
		else {
			System.out.print("Error: "+ game.getTitle() + " is not a proper game title");
			System.exit(0);
		}
	}
	
	/**
	 * Return to the main menu
	 */
	public void returnToMenu() {
		gamePanel.setVisible(false);
		menuPanel.setVisible(true);
	}
	
	/**
	 * Display word in InputTray
	 * @param word Word to display
	 */
	public void addWordToInput(String word) {
		gamePanel.addWordToInput(word);
	}
}