/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

public class Driver {	
	public static FontManager fontManager;
	
	public static void main (String [] args) {
		// load up game font
		fontManager = new FontManager();
		
		// create game
		GUI_window gui = new GUI_window();
		gui.setVisible(true);
	}

}
