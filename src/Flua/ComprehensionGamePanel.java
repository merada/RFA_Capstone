package Flua;

/**
 * Comprehension game panel class, derived from GamePanel, used by GUI 
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class ComprehensionGamePanel extends GamePanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor to create a new Comprehension game
	 * @param i InputHandler to handle user input
	 * @param resource_filename name of file holding resource details for the game
	 */
	public ComprehensionGamePanel(InputHandler i, String resource_filename) {
		super(i, resource_filename);
	}
}
