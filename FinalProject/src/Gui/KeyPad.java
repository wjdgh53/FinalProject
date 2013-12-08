package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class KeyPad extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SECURITY_FILE = "File/System/SecurityCodes";
	
	private JPanel buttonRow1 = new JPanel(new GridLayout(1,3));
	private JPanel buttonRow2 = new JPanel(new GridLayout(1,3));
	private JPanel buttonRow3 = new JPanel(new GridLayout(1,3));
	private JPanel buttonRow4 = new JPanel(new GridLayout(1,3));
	private JTextField numberField = new JTextField("",11);
	private String numberCode = "";
	private boolean validCode = false;
	private boolean isAdmin = false;
	
	/**
	 * Constructs a panel containing a grid of buttons used to enter a password
	 */
	KeyPad()
	{
		
		setLayout(new GridLayout(6,1));
		
		
		numberField.setEditable(false);
		numberField.setBackground(Color.WHITE);
		
		
		
		buttonRow1.add(new Button("1","1",this));
		buttonRow1.add(new Button("2","2",this));
		buttonRow1.add(new Button("3","3",this));
		
		buttonRow2.add(new Button("4","4",this));
		buttonRow2.add(new Button("5","5",this));
		buttonRow2.add(new Button("6","6",this));
		
		buttonRow3.add(new Button("7","7",this));
		buttonRow3.add(new Button("8","8",this));
		buttonRow3.add(new Button("9","9",this));
		
		buttonRow4.add(new Button("Clear","10",this));
		buttonRow4.add(new Button("0","0",this));
		buttonRow4.add(new Button("Enter","11",this));
		
		add(numberField);
		Functions.addBlankSpace(this,1);
		add(buttonRow1);
		add(buttonRow2);
		add(buttonRow3);
		add(buttonRow4);
	}
	/**
	 * Action listener assigned to the keypad.  Creates a password reflecting the user's entries, clears
	 * the password or calls checkCode() to evaluate the password.
	 */
	public void actionPerformed(ActionEvent event)
	{
		if(Integer.parseInt(event.getActionCommand()) < 10)
		{
			if(numberCode.length() < 6)
			{
				numberCode = numberCode + event.getActionCommand();
				numberField.setText(numberField.getText() + "*");
			}
		}
		else if (event.getActionCommand().equals("10"))
		{
			numberCode = "";
			numberField.setText("");
		}
		else if (event.getActionCommand().equals("11"))
			checkPassword();
	}
	/**
	 * Private helper method used to check the user entered password against a text file list of
	 * valid passwords.  If the password checks out, the user is transfered to the transaction screen
	 * along with the appropriate access privilege (server or admin)
	 */
	private void checkPassword()
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File(SECURITY_FILE));
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"ERROR: File Not Found");
		}
			
		while(inputStream.hasNextLine() && !validCode)
		{
			String line = inputStream.nextLine();
				
			if(line.equals(""))
				;
			else
			{
				validCode = numberCode.equals(line.substring(0,4));
				isAdmin = line.substring(5,6).equals("A");
			}
		}
		
		if(validCode)
		{
			GUIUser.setAdminPrivilege(isAdmin);
			MainFrame.adminpanel();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"ERROR: Invalid Password");
			numberCode = "";
			numberField.setText("");
		}
	}
}
