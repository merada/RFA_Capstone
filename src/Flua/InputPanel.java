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
	 * Label holding the current question
	 */
	private Label questionLabel;
	
	/**
	 * Index of current question
	 */
	private int questionIndex = 0;
	
	/**
	 * List holding the game's questions
	 */
	private ArrayList<String> questions = null;
	
	/**
	 * Array holding the user's answers (one answer per question)
	 */
	private String [] answers = null;
	
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
		
		// question label
		Label questionTitle = new Label("Question:");
		questionTitle.setForeground(Color.WHITE);

		mng.putConstraint(SpringLayout.WEST, questionTitle, 18, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, questionTitle, 16, SpringLayout.SOUTH, anchor);
		
		questionLabel = new Label(questions.get(questionIndex));
		questionLabel.setForeground(Color.WHITE);

		mng.putConstraint(SpringLayout.WEST, questionLabel, 46, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, questionLabel, 46, SpringLayout.SOUTH, anchor);

		// previous question button
		Button previous_btn = new Button("<", "Previous ", inputHandler);

		mng.putConstraint(SpringLayout.WEST, previous_btn, 504, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, previous_btn, 314, SpringLayout.SOUTH, anchor);

		// accept answer button
		Button accept_btn = new Button("Accept", "Accept ", inputHandler);

		mng.putConstraint(SpringLayout.WEST, accept_btn, 554, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, accept_btn, 314, SpringLayout.SOUTH, anchor);
		
		// previous question button
		Button next_btn = new Button(">", "Next ", inputHandler);

		mng.putConstraint(SpringLayout.WEST, next_btn, 654, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, next_btn, 314, SpringLayout.SOUTH, anchor);

		// text input field
		inputText = new JTextField();
		inputText.setOpaque(false);
		inputText.setFont(Driver.fontManager.getFont());
		inputText.setForeground(Color.WHITE);
		inputText.setPreferredSize(new Dimension (740 - 50, 200));
		inputText.setAlignmentX(10);
		inputText.setText("Enter your answer here");
		
		mng.putConstraint(SpringLayout.WEST, inputText, 14, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, inputText, 100, SpringLayout.SOUTH, anchor);

		// help label
		// created when resources were extracted
		mng.putConstraint(SpringLayout.WEST, helpLabel, 14, SpringLayout.EAST, anchor);
		mng.putConstraint(SpringLayout.NORTH, helpLabel, 320, SpringLayout.SOUTH, anchor);

		// set layout for this panel
		setLayout(mng);
		
		add(anchor);
		add(questionTitle);
		add(questionLabel);
		add(inputText);
		add(next_btn);
		add(accept_btn);
		add(previous_btn);
		add(helpLabel);
	}
	
	/**
	 * Extract game input to be displayed in the input tray
	 * @param filename Name of file holding input details for the game
	 */
	public void extractInput(String filename) {
		Scanner input_stream = null;
		
		questions = new ArrayList<String>();
		
		try {
			input_stream = new Scanner (new FileInputStream(filename));
			helpLabel = new Label(input_stream.nextLine());
			
			while (input_stream.hasNextLine()) {
				questions.add(input_stream.nextLine());
			}
			
			input_stream.close();
			
			answers = new String [questions.size()];

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
		answers[questionIndex] = inputText.getText();
		nextQuestion();
	}
	
	/**
	 * Move to the next question (without saving the answer)
	 */
	public void nextQuestion() {
		if (questionIndex < questions.size() - 1) {
			questionIndex++;
			displayQuestion();
		}
	}

	/**
	 * Move to the previous question (without saving the answer)
	 */
	public void previousQuestion() {
		if (questionIndex > 0) {
			questionIndex--;
			displayQuestion();
		}
	}
	
	/**
	 * Update the question and answer set to be displayed in the input panel
	 */
	public void displayQuestion() {
		if (answers[questionIndex] != null) {
			inputText.setText(answers[questionIndex]);
			questionLabel.setText(questions.get(questionIndex));
		} else {
			inputText.setText("");
			questionLabel.setText(questions.get(questionIndex));
		}
	}
}
