package Flua;

/**
 * Driver class to initialize Flua
 * 
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class Driver {
	
	/**
	 * FontManager to customize Flua's font
	 */
	public static FontManager fontManager;
	
	public static void main (String [] args) {
		// load up game font
		fontManager = new FontManager();
		
		// create game
		GUI_window gui = new GUI_window();
		gui.setVisible(true);
	}

}
