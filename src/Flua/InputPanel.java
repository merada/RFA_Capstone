package Flua;

import java.awt.Color;
import java.awt.Dimension;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * Panel to process user input
 *
 * @author Lauren Antrobus
 * @author Merada Richter
 */
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
	 * Label holding input instructions
	 */
	private Label helpLabel;
	
	/**
	 * List holding the game's questions
	 */
	private ArrayList<String> questions = null;
	
	/**
	 * List holding the user's answers
	 */
	private ArrayList<String> answers = null;
	
	/**
	 * Create an input to process user input
	 * @param i InputHandler to handle user input
	 */
	public InputPanel(InputHandler i, String filename) {
		inputHandler = i;
		
		extractInput(filename);

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
		
		// help label
		// created when resources were extracted
		mng.putConstraint(SpringLayout.WEST, helpLabel, 14, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, helpLabel, 14, SpringLayout.SOUTH, anchor);
		
		// accept answer button
		Button accept_btn = new Button("Accept", "Accept ", inputHandler);

		mng.putConstraint(SpringLayout.WEST, accept_btn, 600, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, accept_btn, 14, SpringLayout.SOUTH, anchor);
		
		// text input field
		inputText = resetTextField();
		
		mng.putConstraint(SpringLayout.WEST, inputText, 14, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, inputText, 110, SpringLayout.SOUTH, anchor);
		
		setLayout(mng);
		
		add(anchor);
		add(accept_btn);
		add(inputText);
	}
	
	/**
	 * Reset the text field (essentially clear it for a new answer from user)
	 * @return A blank textfield
	 */
	public JTextField resetTextField() {
		JTextField newField = new JTextField();
		newField.setOpaque(false);
		newField.setFont(Driver.fontManager.getFont());
		newField.setForeground(Color.WHITE);
		newField.setPreferredSize(new Dimension (740 - 50, 390 - 150));
		newField.setAlignmentX(10);

		return newField;
	}
	
	/**
	 * Extract game input to be displayed in the input tray
	 * @param filename Name of file holding input details for the game
	 */
	public void extractInput(String filename) {
		Scanner input_stream = null;
		
		questions = new ArrayList<String>();
		answers = new ArrayList<String>();
		
		try {
			input_stream = new Scanner (new FileInputStream(filename));
			helpLabel = new Label(input_stream.nextLine());
			
			while (input_stream.hasNextLine()) {
				questions.add(input_stream.nextLine());
			}
			
			input_stream.close();

		} catch (Exception e) {
			System.out.println("Error: file "+filename+" not found.");
			inputHandler.returnToMenu();
		}
	}
	
	/**
	 * Display word in InputTray
	 * @param word Word to display
	 */
	public void addWord(String word) {
		inputText.setText(inputText.getText() + word);
	}
	
	/**
	 * Accept the current answer as valid, saving both the answer and the question to the user's progress file
	 */
	public void acceptAnswer() {
		answers.add(inputText.getText());
		resetTextField();
	}
}
