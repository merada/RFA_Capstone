package Flua;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * Main panel containing controls to begin a new game
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
public class MenuPanel extends JPanel {
	
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * InputHandler to handle user input
	 */
	private InputHandler inputHandler;
	
	/**
	 * Background image of the menu panel
	 */
	private Image backgroundImage = null;
	
	/**
	 * Create a menu panel, complete with backround image
	 * @param i InputHandler to handle user input
	 */
	public MenuPanel(InputHandler i) {
		inputHandler = i;
		backgroundImage = new ImageIcon("./imgs/bg_menu.jpg").getImage();

		initialize();
	}
	
	/**
	 * Initialize the GUI aspects of the MenuPanel (complete with layout)
	 */
	private void initialize() {
		SpringLayout mng = new SpringLayout();
		
		JPanel anchor = new JPanel(); // to place other components relatively
		anchor.setOpaque(false);
		
		// help text label
		// use html to wrap message within label
		Label help_label = new Label("<html>Click on a button to start a new game<html>");
				
		mng.putConstraint(SpringLayout.WEST, help_label, 95, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, help_label, 260, SpringLayout.SOUTH, anchor);
	
		// buttons
		JPanel button_panel = new JPanel();
		button_panel.setOpaque(false);
		button_panel.setPreferredSize(new Dimension(350, 600));
		button_panel.setLayout(new FlowLayout());
		
		button_panel.add(new Button("New Fill-a-Word game", "Game Fill-a-Word", inputHandler));
		button_panel.add(new Button("New Comprehension game", "Game Comprehension", inputHandler));
		button_panel.add(new Button("Exit", "Exit", inputHandler));
		
		mng.putConstraint(SpringLayout.WEST, button_panel, 120, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, button_panel, 300, SpringLayout.SOUTH, anchor);
		
		setLayout(mng);
		
		add(anchor);
		add(help_label);
		add(button_panel);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, backgroundImage.getWidth(null), backgroundImage.getHeight(null), null);
	}
}
