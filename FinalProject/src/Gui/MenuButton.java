package Gui;

import javax.swing.JButton;

import java.awt.event.ActionListener;

public class MenuButton extends JButton
{
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Sets the initial conditions of the button.  The color and border of the MenuButton objects has
	 * been standardized for this program.
	 * @param label Text which should appear on the button
	 * @param command ActionCommand associated with this button
	 * @param listener ActionListener to be assigned to the button
	 */
	MenuButton(String label, String command, ActionListener listener)
	{
		setText(label);
		setActionCommand(command);
	
	
		addActionListener(listener);
	}
}
