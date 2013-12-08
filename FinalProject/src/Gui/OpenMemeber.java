package Gui;

import javax.swing.*;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class OpenMemeber extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JPanel logoPanel = new JPanel(new GridLayout(1,1));  //Left half of the screen
	
	
	private JPanel exitPanel = new JPanel(new GridLayout(4,2));
	private KeyPad numberPad = new KeyPad();
	private Button exitButton = new Button("Exit","Exit",this);
	private Button BackButton = new Button("Back","Back",this);
	private ImageIcon logo = new ImageIcon("File/logo.JPG");
	private JPanel quarterPanel = new JPanel(new GridLayout(3,1));  //Right quarter of the screen
	private JLabel logoLabel = new JLabel(logo,SwingConstants.CENTER);
	private JLabel logoLabel2 = new JLabel();
	private JLabel logoLabel3 = new JLabel();
	/**
	 * Arranges the various components which populate the log in screen.  Loads the corporate logo from file
	 * and displays it in the left half of the screen.
	 */
	OpenMemeber()
	{	
		
		logoLabel.setVerticalAlignment(SwingConstants.CENTER);
		logoLabel2.setText("Welcome to JAVA World!!");
		logoLabel3.setText("Enter a Password:");
		
		
		logoPanel.add(logoLabel); 
		

		Functions.addBlankSpace(exitPanel,7);
		exitPanel.add(BackButton);
		exitPanel.add(exitButton);
		
		
		quarterPanel.add(logoLabel3);
				
		quarterPanel.add(numberPad);
	
		quarterPanel.add(exitPanel);
		
		
		add(quarterPanel);
		add(logoPanel);
		
		
		

	}
	/**
	 * Ends the program if the user clicks the "Exit" button
	 */
	public void actionPerformed(ActionEvent event)
	{
		if (event.getActionCommand().equals("Exit"))
			System.exit(0);
		
		if (event.getActionCommand().equals("Back"))
			MainFrame.welcomepanel();
	}
}
