/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import javax.swing.JFrame;

public class GUI_window extends JFrame {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private InputHandler inputHandler;
	private GamePanel gamePanel;
	private MenuPanel menuPanel;
	
	// maybe have these as arrays to randomly assign levels
	private String fill_game_filenames = "fill_test.txt";
	private String comp_game_filenames = "comp_test.txt";
	
	/**
	 * Default constructor.
	 */
	public GUI_window() {
		inputHandler = new InputHandler(this);
		initialize();
	}
	
	/**
	 * Initialize the basic parameters for the GUI
	 */
	private void initialize() {
		setTitle("RFA_capstone");
		setSize(1000, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuPanel = new MenuPanel(inputHandler);
		add(menuPanel);
	}
	
	public void startGame(Game game) {
		if (game.getTitle().equals("Fill-a-Word")) {
			menuPanel.setVisible(false);
			gamePanel = new FillWordGamePanel(inputHandler, "./games/" + fill_game_filenames);
			add(gamePanel);
		}
		else if (game.getTitle().equals("Comprehension")) {
			menuPanel.setVisible(false);
			gamePanel = new ComprehensionGamePanel(inputHandler, "./games/" +  comp_game_filenames);
			add(gamePanel);
		}
		else {
			System.out.print("Error: "+ game.getTitle() + " is not a proper game title");
		}
	}
	
	public void returnToMenu() {
		gamePanel.setVisible(false);
		menuPanel.setVisible(true);
	}
}
