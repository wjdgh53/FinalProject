package Gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIUser extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private static boolean isAdmin;
	private JLabel seatLabel;
	private JPanel halfPanel = new JPanel(new GridLayout(1,2));
	private JPanel transactionPanel = new JPanel(new GridLayout(4,1));
	private JPanel receiptButtonPanel = new JPanel(new GridLayout(2,2));
	
	private OpenItem menuPanel = new OpenItem();
	//private JPanel checkoutButtonPanel = new JPanel(new GridLayout(3,1));
	private Button checkoutButton = new Button("Order to pay","Order to pay",this);
	
	
	GUIUser()
	{
		setLayout(new GridLayout(1,2));
	
	
		
		MenuList.clearReceipt();
		
			seatLabel = new JLabel();
			this.add(seatLabel);
			seatLabel.setText(SeatPanel.getSeatChoose());
			seatLabel.setBounds(34, 12, 90, 49);
			seatLabel.setFont(new java.awt.Font("¸¼Àº °íµñ",0,28));
		
		
	
		receiptButtonPanel.add(new Button("Delete Selected Item","Delete Selected Item",this));
		receiptButtonPanel.add(new Button("Remove all","Remove all",this));
		receiptButtonPanel.add(new Button("Exit","Exit",this));
		receiptButtonPanel.add(checkoutButton);
		
		//Functions.addBlankSpace(receiptButtonPanel,6);
		
		
	
		//Functions.addBlankSpace(checkoutButtonPanel,2);
		//checkoutButtonPanel.add(checkoutButton);
		
		
		
		transactionPanel.add(new Button("Categories","Categories",this));
		transactionPanel.add(menuPanel);
		transactionPanel.add(receiptButtonPanel);
		//transactionPanel.add(checkoutButtonPanel);
		
		//halfPanel.add(new ReceiptPanel());
		halfPanel.add(transactionPanel);
		
		
		
		add(halfPanel);
		add(new MenuList());
		
	}
	/**
	 * ActionListener for the transaction screens system oriented or receipt panel oriented buttons.
	 */
	
	public void actionPerformed(ActionEvent event)
	{
		
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
	/**
	 * Setter for the adminPrivilege variable 
	 * @param newAdminPrivilege desired new boolean value for adminPrivelege
	 */
	public static void setAdminPrivilege(boolean newAdminLevel)
	{
		isAdmin = newAdminLevel;
	}
}
