package Gui;

import javax.swing.JButton;

import java.awt.event.ActionListener;

public class Button extends JButton
{
	private static final long serialVersionUID = 1L;
	
	
	Button(String label, String command, ActionListener listener)
	{
		setText(label);
		setActionCommand(command);
	
	
		addActionListener(listener);
	}
}
