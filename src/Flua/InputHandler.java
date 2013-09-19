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
	 * Details the actions to be taken for each event occurring in the GUI
	 */
	public void actionPerformed(ActionEvent e) {
		String[] cmd = e.getActionCommand().split(" ");
		
		switch (cmd[0]) { // lexically listed
			case "Accept":
				
				break;
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
			case "New":
				gui.restartGame(new Game(cmd[1]));
				break;
			case "Word":
				gui.addWordToInput(cmd[1]);
				break;
			default:
				System.out.println("Error: ActionEvent \'" + cmd[0] + "\' not catered for.");
				break;
		}
	}
	
	/**
	 * Used when files are not found and a game cannot be started (InputHandler accessible by all interactive components)
	 */
	public void returnToMenu() {
		gui.returnToMenu();
	}
}
