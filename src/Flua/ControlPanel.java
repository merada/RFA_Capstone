package Flua;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * Panel containing game controls (Main Menu, Dictionary Lookup, Exit, etc) 
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class ControlPanel extends JPanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * Constructor to initialize the Control Panel
	 * @param i InputHandler to handle user input
	 */
	public ControlPanel(InputHandler i, String gameTitle) {
		inputHandler = i;

		initialize(gameTitle);
	}
	
	/**
	 * Initialize the GUI aspects of the ControlPanel (complete with layout)
	 * @param gameTitle Title of the game currently being played
	 */
	private void initialize(String gameTitle) {
		setOpaque(false);
		setPreferredSize(new Dimension(300, 385));
		
		SpringLayout mng = new SpringLayout();
		
		JPanel anchor = new JPanel(); // to place other components relatively
		anchor.setOpaque(false);
		
		// buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension (200, 300));
		buttonPanel.setLayout(new FlowLayout());

		buttonPanel.add(new Button("New Game", "New " + gameTitle, inputHandler));
		buttonPanel.add(new Button("Main Menu", "Menu", inputHandler));
		buttonPanel.add(new Button("Dictionary", "Dictionary", inputHandler));
		buttonPanel.add(new Button("Exit", "Exit", inputHandler));
		
		mng.putConstraint(SpringLayout.WEST, buttonPanel, 20, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, buttonPanel, 80, SpringLayout.SOUTH, anchor);
		
		// game title
		Label gameTitleLabel = new Label(gameTitle);
				
		mng.putConstraint(SpringLayout.WEST, gameTitleLabel, 40, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, gameTitleLabel, 330, SpringLayout.SOUTH, anchor);

		// set layout for this tray
		setLayout(mng);
		
		add(anchor);
		add(buttonPanel);
		add(gameTitleLabel);
	}
}
