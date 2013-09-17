/**
 * Panel to process user input.
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class InputPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private InputHandler inputHandler;
	private JTextField inputText;
	
	
	public InputPanel(InputHandler i) {
		inputHandler = i;

		initialize();
	}
	
	
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
		
		mng.putConstraint(SpringLayout.WEST, inputText, 14, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, inputText, 14, SpringLayout.SOUTH, anchor);
		
		setLayout(mng);
		
		add(anchor);
		add(inputText);
	}
	
}
