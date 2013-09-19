package Flua;

/**
 * Wrapper class used to differentiate between available game types
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class Game {
	
	/**
	 * Title of the game
	 */
	private String gameTitle = null;
	
	/**
	 * Construct a game with title set to default value 'undefined'
	 */
	public Game() {
		gameTitle = "undefined";
	}
	
	/**
	 * Construct a game with a specific title
	 * @param t Title of the game
	 */
	public Game(String t) {
		gameTitle = t;
	}
	
	/**
	 * Set a new title to an existing game
	 * @param t New title to be given to game
	 */
	public void setTitle(String t) {
		gameTitle = t;
	}
	
	/**
	 * Accessor method for game title
	 * @return The title of the game
	 */
	public String getTitle() {
		return gameTitle;
	}
}
