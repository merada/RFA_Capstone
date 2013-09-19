package Flua;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class to handle all user input for the GUI
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class InputHandler implements ActionListener {
	
	/**
	 * GUI which this InputHandler responds to
	 */
	private GUI_window gui;
	
	/**
	 * Create an InputHandler linked to a game
	 * @param g GUI which this InputHandler responds to
	 */
	public InputHandler(GUI_window g) {
		gui = g; // so messages can be sent both ways
	}
	
	/**
	 * Details actions to be taken for each event occurring in the GUI
	 */
	public void actionPerformed(ActionEvent e) {
		String[] cmd = e.getActionCommand().split(" ");
		
		
		switch (cmd[0]) { // lexically listed
			case "Dictionary":
				(new Dictionary()).run();
				break;
			case "Exit":
				System.exit(0);
				break;			
			case "Game":
				gui.startGame(new Game(cmd[1]));
				break;
			case "Menu":
				gui.returnToMenu();
				break;
			case "Word":
				gui.addWordToInput(cmd[1]);
				break;
			default:
				System.out.println("Error: ActionEvent \'" + cmd + "\' not catered for.");
				break;
		}
	}
}
