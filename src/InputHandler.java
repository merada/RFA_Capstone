/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandler implements ActionListener {
	
	private GUI_window gui;
	
	public InputHandler(GUI_window g) {
		gui = g; // so messages can be sent both ways
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		switch (cmd) { // lexically listed
			case "Comprehension":
				gui.startGame(new Game("Comprehension"));
				break;
			case "Dictionary":
				(new Dictionary()).run();
				break;
			case "Exit":
				//gui.add(new PopupMenu()); "Are you sure?"
				System.exit(0);
				break;			
			case "Fill-a-Word":
				gui.startGame(new Game("Fill-a-Word"));
				break;
			case "Menu":
				gui.returnToMenu();
				break;
			default:
				System.out.println("Error: ActionEvent \'" + cmd + "\' not catered for.");
				break;
		}
		
	}
}
