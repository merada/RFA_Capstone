package Flua;

/*
 * Capstone Project: Reading Fluency Aid
 * Lauren Antrobus & Merada Richter
 * August 2013
 * 
 * Dictionary GUI class
 */
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
* This class provides a dictionary GUI for the Flua reading project.
* @author Lauren Antrobus, Merada Ricther
*/
public class Dictionary extends javax.swing.JFrame
{
    /*// main method (for testing)
    public static void main (String [] args)
    {
        new Dictionary().run();   
    }*/

    /**
     * Default constructor method.
     */
    public Dictionary()
    {
		initialiseWindow();
		populateDictionary();
    }

    /**
     * Parameterised constructor method.
     * Initialises dictionary having searched for a specified word
     * @param word Word being searched
     */
    public Dictionary(String word)
    {
		initialiseWindow();
		populateDictionary();
		searchWord(word);
    }

    /**
     * Populates dictionary data from file. 
     */
    private void populateDictionary()
    {
	BufferedReader infile = null;
	try
	{
	    String line;
	    String[] entry;
	    infile = new BufferedReader(new FileReader(filename));
	    
	    while ((line = infile.readLine()) != null)
	    {
		entry = line.split("#");
		dic.put(entry[0].toUpperCase(), entry[1]);
	    }
	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog(null, "Error populating dictionary.", "Error!", JOptionPane.ERROR_MESSAGE);
	    e.printStackTrace();
	}
	finally
	{
	    try
	    {
		if (infile != null) {
		    infile.close();
		}
	    }
	    catch (IOException ex){
		ex.printStackTrace();
	    }
	}
    }

    /**
     * Method to initialise JFrame components.
     */ 
    private void initialiseWindow()
    {
		// initialise widgets
        mainPanel = new javax.swing.JPanel();
        textScrollPane = new javax.swing.JScrollPane();
        definitionTextArea = new javax.swing.JTextArea();
        wordLabel = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

		// Window settings
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dictionary");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(0, 102, 255));
        setResizable(false);

		// background colour
        mainPanel.setBackground(new java.awt.Color(145, 200, 255));

		// text area settings
        definitionTextArea.setEditable(false);
        definitionTextArea.setColumns(20);
        definitionTextArea.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        definitionTextArea.setLineWrap(true);
        definitionTextArea.setRows(5);
        definitionTextArea.setWrapStyleWord(true);
        textScrollPane.setViewportView(definitionTextArea);

		// word label settings
        wordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

		// search button
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchButtonActionPerformed(evt);
            }
        });
		
		// edit button
        editButton.setText("Edit word");
        editButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editButtonActionPerformed(evt);
            }
        });

		// panel layout settings
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(wordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(editButton))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
   
        this.setLocationByPlatform(true);
        
        // window image icon
        setIconImage(icon.getImage());
        
    }// end initialiseWindow method

    /**
     * Method to trigger search function.
     * Actionlistener reaction for search button.
     * @param evt 
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchButtonActionPerformed
    {
		String word = searchTextField.getText().toUpperCase();
		searchWord(word);
    }

    /**
     * Method to allow editing of dictionary database.
     * Actionlistener reaction for the edit button.
     * @param evt 
     */
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editButtonActionPerformed
    {
        String word = wordLabel.getText();
		if(!word.equals(""))
		{
			// Enter edit mode
			if(editButton.getText().equals("Edit word"))
			{
			definitionTextArea.setEditable(true);
			definitionTextArea.setBackground(new Color(254, 241, 146));
			editButton.setText("Save word");
			}
			else // Exit edit mode, save entered text
			{
			definitionTextArea.setEditable(false);
			String def = definitionTextArea.getText();
			definitionTextArea.setBackground(Color.WHITE);
			addWord(word, def);
			editButton.setText("Edit word");
			
			}
		}
    }
    
    
    /**
     * Method to add a word to dictionary database.
     * Adds word and definition specified by user to both current hashtable
     * and long-terms storage for future use.
     * @param word Word to be added
     * @param def Word's definition
     */
    private void addWord(String word, String def)
    {
		FileWriter outfile = null;
		try
		{
			outfile = new FileWriter(filename,true);
			outfile.append(word+"#"+def+"\n");
			dic.put(word, def);
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(null, "Could not save your edit to file.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		finally
		{
			try {
			if(outfile != null)
				outfile.close();
			}
			catch (IOException ex)
			{
			ex.printStackTrace();
			}
		}
    }
    
    
    /**
     * Method to search dictionary for a word.
     * Output displayed to dictionary screen.
     * @param word Word to search for
     */
    private void searchWord(String word)
    {
		if(!word.equals(""))
		{
			String def = dic.get(word);
			wordLabel.setText(word);    
			definitionTextArea.setText(def);
			/* If word does not exist in dictionary, user is asked if they
			 * would like to add it to the database
			 */
			if(def == null)
			{
			int opt = JOptionPane.showConfirmDialog(null, "The word you searched could not be found - would you like to add it to the dictionary? ", "Add word?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(opt == 0) // if 'yes'
				editButton.doClick();
			}
		}
    }
    
    /**
     * Method to run a dictionary GUI object.
     */ 
    public void run()
    {
		/* create and display form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
			     new Dictionary().setVisible(true);
			}
		});
	}
    
    // Variable declaration
    // GUI widgets
    private javax.swing.JTextArea definitionTextArea;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JScrollPane textScrollPane;
    private javax.swing.JLabel wordLabel;
    // other variables
    private Hashtable<String, String> dic = new Hashtable<String, String>(); // dictionary datastructure
    private String filename = "./dict/dictionary_data.txt"; // source file
    private ImageIcon icon = new ImageIcon("./dict/Dictionary.png");
}
