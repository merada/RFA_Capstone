package Flua;
/**
 * Panel to process user input.
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class InputPanel extends JPanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * Text field to hold user input text
	 */
	private JTextField inputText;
	
	/**
	 * Create an input to process user input
	 * @param i InputHandler to handle user input
	 */
	public InputPanel(InputHandler i) {
		inputHandler = i;

		initialize();
	}
	
	/**
	 * Initialize the GUI aspects of the InputPanel (complete with layout)
	 */
	public void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(740, 390));
		
		SpringLayout mng = new SpringLayout();
		
		JPanel anchor = new JPanel(); // to place other components relatively
		anchor.setOpaque(false);
		
		// text input field
		inputText = new JTextField();
		inputText.setFont(Driver.fontManager.getFont());
		inputText.setPreferredSize(new Dimension (740 - 50, 390 - 50));
		inputText.setAlignmentX(10);
		
		mng.putConstraint(SpringLayout.WEST, inputText, 14, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, inputText, 14, SpringLayout.SOUTH, anchor);
		
		setLayout(mng);
		
		add(anchor);
		add(inputText);
	}
}
