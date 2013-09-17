/**
 * Parent panel to initialize and manage individual game panels
 * (namely the Control, Word, Resource and Input panels).
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GamePanel extends JPanel {

	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private InputHandler inputHandler;
	
	private Image backgroundImage = null;
	
	private ControlPanel controlPanel;
	private WordPanel wordPanel;
	private ResourcePanel resourcePanel;
	private InputPanel inputPanel;
	
	public GamePanel(InputHandler i, String resource_filename) {
		inputHandler = i;
		backgroundImage = new ImageIcon("./imgs/bg_game.jpg").getImage();
		
		initialize(resource_filename);
	}
	
	public void initialize(String resource_filename) {
		setOpaque(true);
		
		resourcePanel = new ResourcePanel(inputHandler, resource_filename);
		controlPanel = new ControlPanel(inputHandler);
		inputPanel = new InputPanel(inputHandler);
		wordPanel = new WordPanel(inputHandler);

		SpringLayout mng = new SpringLayout();
		mng.putConstraint(SpringLayout.WEST, controlPanel, 1, SpringLayout.EAST, resourcePanel);
		mng.putConstraint(SpringLayout.WEST, wordPanel, 1, SpringLayout.EAST, inputPanel);
		mng.putConstraint(SpringLayout.NORTH, inputPanel, 1, SpringLayout.SOUTH, resourcePanel);
		mng.putConstraint(SpringLayout.NORTH, wordPanel, 1, SpringLayout.SOUTH, controlPanel);
		setLayout(mng);
		
		add(resourcePanel);
		add(controlPanel);	
		add(inputPanel);	
		add(wordPanel);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, backgroundImage.getWidth(null), backgroundImage.getHeight(null), null);
	}
}
