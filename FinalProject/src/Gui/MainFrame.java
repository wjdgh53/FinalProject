package Gui;

import java.awt.Container;

import javax.swing.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainFrame extends JFrame {
	
	private static JPanel mainPanel = new JPanel();
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);	
	}
	MainFrame() 
	{
		try {
			//	setExtendedState(MAXIMIZED_BOTH);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				{
					//setExtendedState(MAXIMIZED_BOTH);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					getContentPane().add(mainPanel);
					welcomepanel();
				}
				pack();
				
				this.setSize(1000, 800);
			} catch (Exception e) {
			    //add your error handling code here
				e.printStackTrace();
			}
			
	}
	static void welcomepanel(){
		mainPanel.removeAll();
		mainPanel.add(new WelcomePanel());
		refresh(mainPanel);
	}
	static void seatpanel(){
		mainPanel.removeAll();
		mainPanel.add(new SeatPanel());
		refresh(mainPanel);
		
	}
	static void editpanel(){
		mainPanel.removeAll();
		mainPanel.add(new SimulPanel());
		refresh(mainPanel);
	}
	static void refresh(Container contentPane){
		contentPane.setVisible(false);
		contentPane.setVisible(true);
	}

}
