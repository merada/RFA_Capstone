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
	public ControlPanel(InputHandler i) {
		inputHandler = i;

		initialize();
	}
	
	/**
	 * Initialize the GUI aspects of the ControlPanel (complete with layout)
	 */
	private void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(255, 385));
		
		SpringLayout mng = new SpringLayout();
		
		JPanel anchor = new JPanel(); // to place other components relatively
		anchor.setOpaque(false);
		
		// buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setPreferredSize(new Dimension (140, 300));
		buttonPanel.setLayout(new FlowLayout());
		
		buttonPanel.add(new Button("Menu", "Menu", inputHandler));
		buttonPanel.add(new Button("Help", "Help", inputHandler));
		buttonPanel.add(new Button("Dictionary", "Dictionary", inputHandler));
		buttonPanel.add(new Button("Exit", "Exit", inputHandler));
		
		mng.putConstraint(SpringLayout.WEST, buttonPanel, 50, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, buttonPanel, 80, SpringLayout.SOUTH, anchor);
		
		setLayout(mng);
		
		add(anchor);
		add(buttonPanel);
	}
}
