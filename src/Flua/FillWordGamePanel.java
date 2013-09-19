package Flua;
/**
 * Fill-a-Word game panel class, derived from GamePanel, used by GUI 
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */

public class FillWordGamePanel extends GamePanel {
	
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor to create a new Fill-a-Word game
	 * @param i InputHandler to handle user input
	 * @param resource_filename name of file holding resource details for the game
	 */
	public FillWordGamePanel(InputHandler i, String resource_filename) {
		super("Fill-a-Word", i, resource_filename);
	}
}
