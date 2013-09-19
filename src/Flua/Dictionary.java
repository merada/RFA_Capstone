package Flua;

/*
 * Capstone Project: Reading Fluency Aid
 * Lauren Antrobus & Merada Richter
 * August 2013
 * 
 * Dictionary GUI class
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Dictionary extends javax.swing.JFrame
{
    Hashtable <String, String> dic = new Hashtable <String, String>();
    
    /* Default constructor method
     */
    public Dictionary()
    {
	initComponents();
	this.setLocationByPlatform(true);
	populateDictionary();
    }
    
    /* Paramaterised constructor
     * Initialises for a given word 
     */
    public Dictionary(String word)
    {
	initComponents();
	populateDictionary();
	this.setLocationByPlatform(true);
	searchWord(word.toUpperCase());
    }
    
    /* Method to populate the dictionary data
     * Currently reading in from a txt file and storing in a hashtable
     * (Full implementation will probably use a SQL database connection)
     */
    private void populateDictionary()
    {
	try
	{
	    String word, definition;
	    Scanner input = new Scanner (new FileReader("./dict/words.txt"));
	    input.useDelimiter("#");
	    while(input.hasNextLine())
	    {
		word = input.next().toUpperCase();
		definition = input.next();
		dic.put(word, definition);
		System.out.println(word);
		System.out.println(definition);
		System.out.println();
	    }
	    input.close();
	}
	catch(IOException e)
	{
	    JOptionPane.showMessageDialog(null, "Error populating dictionary.", "Error!", JOptionPane.ERROR_MESSAGE);
	    this.dispose();
	}
    }
    
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        mainPanel = new javax.swing.JPanel();
        textScrollPane = new javax.swing.JScrollPane();
        definitionTextArea = new javax.swing.JTextArea();
        searchButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        wordLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dictionary");
        setForeground(new java.awt.Color(0, 102, 255));
        setResizable(false);
		setLocationRelativeTo(null);

        definitionTextArea.setEditable(false);
        definitionTextArea.setColumns(20);
        definitionTextArea.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        definitionTextArea.setLineWrap(true);
        definitionTextArea.setRows(5);
        definitionTextArea.setWrapStyleWord(true);
        textScrollPane.setViewportView(definitionTextArea);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchButtonActionPerformed(evt);
            }
        });

        wordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(textScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(wordLabel)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(wordLabel)
                .addGap(26, 26, 26)
                .addComponent(textScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(21, 21, 21))
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
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchButtonActionPerformed
    {//GEN-HEADEREND:event_searchButtonActionPerformed
        // TODO add your handling code here:
	String word = searchTextField.getText().toUpperCase();
	searchWord(word);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchWord(String word)
    {
	String def = dic.get(word);
	wordLabel.setText(word);
	definitionTextArea.setText(def);
    }
    
    
    /* Main method for testing purposes
     * (Dictionary would typically be called 
     * from another GUI class)
     */
    public void run()
    {
	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		new Dictionary("escalator").setVisible(true);
	    }
	});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea definitionTextArea;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JScrollPane textScrollPane;
    private javax.swing.JLabel wordLabel;
    // End of variables declaration//GEN-END:variables
}
