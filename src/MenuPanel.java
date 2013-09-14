/**
 * Class description
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 * @date 2013.08.06
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class MenuPanel extends JPanel {
	
	/**
	 * auto-generated serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private InputHandler inputHandler;
	
	private Image backgroundImage = null;
	
	
	public MenuPanel(InputHandler i) {
		inputHandler = i;
		backgroundImage = new ImageIcon("./imgs/bg_menu_00.jpg").getImage();

		initialize();
	}
	
	
	private void initialize() {
		SpringLayout mng = new SpringLayout();
		
		JPanel anchor = new JPanel(); // to place other components relatively
		anchor.setOpaque(false);
	
		// buttons
		JPanel button_panel = new JPanel();
		button_panel.setOpaque(false);
		button_panel.setPreferredSize(new Dimension(200, 600));
		button_panel.setLayout(new FlowLayout());
		
		JButton btn_fillAword = new JButton("New Fill-a-Word game");
		btn_fillAword.setActionCommand("Fill-a-Word");
		btn_fillAword.addActionListener(inputHandler);
		button_panel.add(btn_fillAword);
		
		JButton btn_comprehension = new JButton("New Comprehension game");
		btn_comprehension.setActionCommand("Comprehension");
		btn_comprehension.addActionListener(inputHandler);
		button_panel.add(btn_comprehension);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.addActionListener(inputHandler);
		button_panel.add(btn_exit);
		
		mng.putConstraint(SpringLayout.WEST, button_panel, 150, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, button_panel, 300, SpringLayout.SOUTH, anchor);
		
		setLayout(mng);
		
		add(anchor);
		add(button_panel);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, backgroundImage.getWidth(null), backgroundImage.getHeight(null), null);
	}
}
