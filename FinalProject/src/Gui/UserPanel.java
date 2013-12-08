package Gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
public class UserPanel extends JPanel implements ActionListener {
	private JLabel seatLabel;
	
	private JPanel orderPanel;
	private JPanel controlPanel;
	private JButton returnButton;
	private JPanel itemPanel;
	private OpenItem menuPanel = new OpenItem();
	/**
	 * Auto-generated main method to display this 
	 * JPanel inside a new JFrame.
	 */

	public UserPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setPreferredSize(new Dimension(1000, 800));
			this.setLayout(null);
			{
				seatLabel = new JLabel();
				this.add(seatLabel);
				seatLabel.setText(SeatPanel.getSeatChoose());
				seatLabel.setBounds(34, 12, 90, 49);
				seatLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,28));
			}
			{
				itemPanel = new JPanel();
				this.add(itemPanel);
				itemPanel.add(menuPanel);
				itemPanel.setBounds(153, 37, 175, 219);
			}
			{
				returnButton = new JButton();
				this.add(returnButton);
				returnButton.setText("Return");
				returnButton.setBounds(153, 275, 175, 35);
				returnButton.setFont(new java.awt.Font("¸¼Àº °íµñ",0,20));
				returnButton.addActionListener(this);
			}
			{
				controlPanel = new JPanel(new GridLayout(2,2));
				this.add(controlPanel);
				controlPanel.add(new Button("Delete Selected Item","Delete Selected Item",this));
				controlPanel.add(new Button("Remove all","Remove all",this));
				controlPanel.add(new Button("Exit","Exit",this));
				controlPanel.add(new Button("Order to pay","Order to pay",this));
				controlPanel.setBounds(83, 479, 245, 223);
			}
			{
				orderPanel = new JPanel();
				this.add(orderPanel);
				orderPanel.add(new MenuList());
				orderPanel.setBounds(439, 45, 517, 698);
			}
			
			//add(new MenuList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if (event.getActionCommand().equals("Return")){	
			menuPanel.displayCategories();			
		}
		if(event.getActionCommand().equals("Exit"))
			MainFrame.welcomepanel();
		else if(event.getActionCommand().equals("Delete Selected Item"))
			MenuList.deleteItem();
		else if(event.getActionCommand().equals("Remove all"))
			MenuList.clearReceipt();			
		else if(event.getActionCommand().equals("Order to pay")){
			MenuList.saveReceipt();
			JOptionPane.showMessageDialog(null,"Completed Receipt!");
		}
		else if(event.getActionCommand().equals("Categories"))
			menuPanel.displayCategories();

	}

}
