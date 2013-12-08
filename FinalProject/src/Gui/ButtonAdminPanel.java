package Gui;

import javax.swing.JPanel;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonAdminPanel extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button exitButton = new Button("Go Home","Go Home",this);
	
	/**
	 * Arranges the "Back" button on its own JPanel
	 */
	ButtonAdminPanel()
	{
		setLayout(new GridLayout(3,2));
		
		
		
		Functions.addBlankSpace(this, 6);
		add(exitButton);
		
	}
	/**
	 * Listens for the "Back" button to be clicked and returns the user to the transaction screen if it is
	 */
	public void actionPerformed(ActionEvent event)
	{
		if(event.getActionCommand().equals("Go Home"))
			MainFrame.welcomepanel();
	}
}
