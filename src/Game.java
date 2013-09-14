/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

public class Game {
	
	private String gameTitle = null;
	
	public Game() {
		gameTitle = "undefined";
	}
	
	public Game(String t) {
		gameTitle = t;
	}
	
	public void setTitle(String t) {
		gameTitle = t;
	}
	
	public String getTitle() {
		return gameTitle;
	}
}
