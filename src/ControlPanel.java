/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private InputHandler inputHandler;
	
	
	public ControlPanel(InputHandler i) {
		inputHandler = i;

		initialize();
	}
	
	
	private void initialize() {
		setOpaque(false);
		setPreferredSize(new Dimension(255, 385));
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new GridLayout(2,1));
		
		JButton btn_menu = new JButton("Menu");
		btn_menu.addActionListener(inputHandler);
		btn_menu.setSize(20, 20);
		buttonPanel.add(btn_menu);
		
		JButton btn_dict = new JButton("Dictionary");
		btn_dict.addActionListener(inputHandler);
		btn_dict.setSize(20, 20);
		buttonPanel.add(btn_dict);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.addActionListener(inputHandler);
		btn_exit.setSize(20, 20);
		buttonPanel.add(btn_exit);
		
		add(buttonPanel, c);
	}
}
