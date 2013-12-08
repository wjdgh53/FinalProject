package Gui;


import javax.swing.JPanel;


import java.awt.GridLayout;


public class GUIAdministrator extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Panel1 = new JPanel();
	private JPanel Panel2 = new JPanel();
	
	
	GUIAdministrator()
	{
		setLayout(new GridLayout(2,1));
		
		Panel1.add(new Manage());
		
		Panel2.add(new ButtonAdminPanel());
		
		add(Panel1);
		add(Panel2);
	}
}
