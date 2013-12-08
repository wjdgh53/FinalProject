package Gui;
import logic.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.io.*;
import java.awt.event.*;


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
public class Manage extends JPanel implements ActionListener, ListSelectionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CATEGORY_LIST = "File/Menu/CategoryList";
	private Category categorys = new Category();
	private DefaultListModel<String> categoryModel = new DefaultListModel<String>();
	private DefaultListModel<String> itemModel = new DefaultListModel<String>();
	private JList<String> categoryList = new JList<String>(categoryModel);
	private JList<String> itemList = new JList<String>(itemModel);
	private JTextField categoryNameField = new JTextField("Enter Category Name",31);
	private JTextField itemNameField = new JTextField("Enter Item Name",31);
	private JTextField itemPriceField = new JTextField("Enter Item Price",31);
	private JTextField itemDescriptionField = new JTextField("Enter Item Description",31);
	private JLabel titleLabel = new JLabel("Edit Menu",SwingConstants.CENTER);
	private JLabel categoryLabel = null;
	private JLabel itemLabel = new JLabel("Select an Item (" + itemModel.getSize() +"/"+ itemModel.getSize()+")");
	private JPanel categoryPanel = new JPanel(new GridLayout(3,1));
	private JPanel categoryHeader = new JPanel(new GridLayout(2,1));
	private JPanel categoryLower = new JPanel(new GridLayout(3,1));
	private JPanel categoryButtons = new JPanel(new GridLayout(1,3));
	private JPanel categoryFieldPanel = new JPanel(new GridLayout(1,2));
	private JPanel itemPanel = new JPanel(new GridLayout(3,1));
	private JPanel itemLower = new JPanel(new GridLayout(4,1));
	private JPanel itemButtons = new JPanel(new GridLayout(1,1));
	private JPanel itemNameFieldPanel = new JPanel(new GridLayout(1,2));
	private JPanel itemPriceFieldPanel = new JPanel(new GridLayout(1,2));
	private JPanel itemDescriptionFieldPanel = new JPanel(new GridLayout(1,2));

	/**
	 * Arranges all components onto a JPanel.  Categories are added to a JList in the upper half of the panel,
	 * while items are displayed in a JList on the lower half of the panel.  The item JList is refreshed whenever
	 * the user selects a new category to display the items in that category.  
	 */
	Manage()
	{
		
		setLayout(new GridLayout(2,1));
		this.setPreferredSize(new java.awt.Dimension(392, 595));
		readArrays();
		//Category newCategory = categorys;
		LinkedList  node = categorys.getfirst();
		while (node != null) {
			categoryModel.addElement(node.getCategoryName());
			node = node.getCategoryLink();
		}
		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryList.addListSelectionListener(this);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setFont(new Font(Font.SERIF,Font.BOLD,24));
		categoryLabel = new JLabel("Select a Category (" + categoryModel.getSize() + "/"+ categoryModel.getSize()+")");
		categoryLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		itemLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		
		
		
		categoryNameField.addMouseListener(new TextFieldEraser());
		
		itemNameField.addMouseListener(new TextFieldEraser());
		itemDescriptionField.addMouseListener(new TextFieldEraser());
		
		
		
		categoryHeader.add(titleLabel);
		titleLabel.setText("Menu Manager - Administrator");
		categoryHeader.add(categoryLabel);
		
		categoryButtons.add(new Button("Add","CatAdd",this));
		categoryButtons.add(new Button("Edit","CatEdit",this));
		categoryButtons.add(new Button("Delete","CatDelete",this));
		
		
		categoryFieldPanel.add(new JLabel("New Category Name:",SwingConstants.RIGHT));
		categoryFieldPanel.add(categoryNameField);
		
		
		categoryLower.add(categoryButtons);
		categoryLower.add(categoryFieldPanel);
		Functions.addBlankSpace(categoryLower,1);
		
		categoryPanel.add(categoryHeader);
		categoryPanel.add(new JScrollPane(categoryList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
		categoryPanel.add(categoryLower);
		
		itemButtons.add(new Button("Add","ItemAdd",this));
		itemButtons.add(new Button("Edit","ItemEdit",this));
		itemButtons.add(new Button("Delete","ItemDelete",this));
		
		
		itemNameFieldPanel.add(new JLabel("New Item Name:",SwingConstants.RIGHT));
		itemNameFieldPanel.add(itemNameField);
		
		
		itemPriceFieldPanel.add(new JLabel("New Item Price:",SwingConstants.RIGHT));
		itemPriceFieldPanel.add(itemPriceField);
		
		itemPriceField.addMouseListener(new TextFieldEraser());
		
		itemDescriptionFieldPanel.add(new JLabel("New Item Description:",SwingConstants.RIGHT));
		itemDescriptionFieldPanel.add(itemDescriptionField);
		
		itemLower.add(itemButtons);
		itemLower.add(itemNameFieldPanel);
		itemLower.add(itemPriceFieldPanel);
		itemLower.add(itemDescriptionFieldPanel);
		
		itemPanel.add(itemLabel);
		itemLabel.setPreferredSize(new java.awt.Dimension(693, 56));
		itemPanel.add(new JScrollPane(itemList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
		itemPanel.add(itemLower);
		
		add(categoryPanel);
		add(itemPanel);
	}
	/**
	 * Listener associated with the category JList which refreshes the item JList to represent the food items
	 * associated with the newly selected category.
	 */
	public void valueChanged(ListSelectionEvent event)
	{
		try
		{

			String cat = categoryList.getSelectedValue();
			itemModel.removeAllElements();
			if (cat == null) {
			
			} else {
			LinkedListNode firstItem = categorys.findCategory(cat).getFirstItem();
			while (firstItem != null) {	
				itemModel.addElement(Functions.toMoney(firstItem.getPrice())+ "     "
													+firstItem.getName()+"     "+firstItem.getDescription());
				
				firstItem =firstItem.getlink();
			}
			itemLabel.setText("Select an Item (" + itemModel.getSize() +"/"+itemModel.getSize()+")");
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			itemLabel.setText("Select an Item (0/0)");
		}
	}
	/**
	 * Responds to user selections by add/changing/deleting categories and items.  Contains error checking
	 * to ensure that the user enters a valid price amount for the item price, and does not enter a blank space
	 * for item or category names.
	 */
	public void actionPerformed(ActionEvent event)
	{
		Category newCategory = categorys;
		String cat	= categoryList.getSelectedValue();
		String choice = itemList.getSelectedValue();
		
		if (choice ==null) {
			
		}else {
		String[] ItemName = choice.split("     ");
		choice =ItemName[1]; 
		}

		if(event.getActionCommand().equals("CatAdd"))
		{
			String newName = categoryNameField.getText().trim();
			
		 if(newName.equals("") || newName.equals("Enter Category Name"))
				JOptionPane.showMessageDialog(null,"ERROR: Invalid Category Name");
			else
			{
				
				categorys.addCategory(newName);
				categoryNameField.setText("");
				resetLists();
				
			}
		}
		else if(event.getActionCommand().equals("CatDelete"))
		{
			
			newCategory.deleteCategory(cat);
			
			resetLists();
		}
		else if(event.getActionCommand().equals("CatEdit"))
		{
			String newName = categoryNameField.getText().trim();
			
			if(newName.equals("") || newName.equals("Enter Category Name"))
				JOptionPane.showMessageDialog(null,"ERROR: Invalid Category Name");
			else
			{	if (cat != null) {
				
				newCategory.findCategory(cat).setCategoryName(newName);
				categorys  = newCategory;
				categoryNameField.setText("");
				resetLists();
			}
			}
		}
		else if(event.getActionCommand().equals("ItemAdd"))
		{
			String newName = itemNameField.getText().trim();
			String newPrice = itemPriceField.getText().trim();
			String newDescription = itemDescriptionField.getText().trim();
			
			if(newName.equals("") || newPrice.equals("") || newName.equals("Enter New Item") || newDescription.equals("Enter new Description") || newName.equals(""))
				JOptionPane.showMessageDialog(null,"ERROR: Invalid Input");
			else if(!Functions.isMoney(newPrice))
				JOptionPane.showMessageDialog(null,"ERROR: Invalid Price");
			else
			{
				if (cat != null) {
				newCategory.findCategory(cat).addItem(String.valueOf(Functions.toAmount(newPrice)), newName, newDescription);
				itemModel.addElement(Functions.toMoney(newCategory.findCategory(cat).findItem(newName).getPrice()) + "     "
				                                  + newCategory.findCategory(cat).findItem(newName).getName() + "     "+ newCategory.findCategory(cat).findItem(newName).getDescription());
				itemNameField.setText("");
				itemPriceField.setText("");
				itemDescriptionField.setText("");
				resetItemList(cat);
				}
			}
		}
		else if(event.getActionCommand().equals("ItemDelete"))
		{
			if (choice != null) {
			newCategory.findCategory(cat).deleteItem(choice);
				resetItemList(cat);
			}
		}
		else if(event.getActionCommand().equals("ItemEdit"))
		{
			String newName = itemNameField.getText().trim();
			String newPrice = itemPriceField.getText().trim();
			String newDescription = itemDescriptionField.getText().trim();
			
			if(newName.equals("Enter Item Name"))
				newName = "";
			if(newPrice.equals("Enter Item Price"))
				newPrice ="";
			if(newDescription.equals("Enter Item Description"))
				newDescription = "";
			if(newName.equals("") && newPrice.equals("")&&newDescription.equals(""))
				//all empty error
				JOptionPane.showMessageDialog(null,"ERROR: Invalid Input");
			else if(newName.equals("") && newDescription.equals(""))
				//fix price
			{
				if(!Functions.isMoney(newPrice))
					JOptionPane.showMessageDialog(null,"ERROR: Invalid Price");
				else 
				{	
					if (cat != null && choice != null)
						newCategory.findCategory(cat).findItem(choice).setPrice(String.valueOf(Functions.toAmount(newPrice)));
					//newCategory.findCategory(cat).findItem(choice).setDescription(newDescription);
					itemPriceField.setText("");
					//itemDescriptionField.setText("");
					resetItemList(cat);
				}
			}
			else if(newName.equals("") && newPrice.equals(""))
				//fix description
			{
				if (cat != null && choice != null)
					newCategory.findCategory(cat).findItem(choice).setDescription(newDescription);
				itemDescriptionField.setText("");
				resetItemList(cat);				
			}
			else if(newDescription.equals("") && newPrice.equals(""))
				//fix name
			{
				if (cat != null && choice != null)
					newCategory.findCategory(cat).findItem(choice).setName(newName);		
				itemNameField.setText("");				
				resetItemList(cat);

			}
			else if(newPrice.equals(""))
				//fix name, description
			{
				if (cat !=null && choice != null){
					newCategory.findCategory(cat).findItem(choice).setName(newName);
					newCategory.findCategory(cat).findItem(choice).setDescription(newDescription);
				}
				itemNameField.setText("");
				itemDescriptionField.setText("");
				resetItemList(cat);

			}
			else if(newDescription.equals(""))
				//fix name, price
			{
				if(!Functions.isMoney(newPrice))
					JOptionPane.showMessageDialog(null,"ERROR: Invalid Price");
				else 
				{	
					if (cat !=null && choice != null){
						newCategory.findCategory(cat).findItem(choice).setName(newName);
						newCategory.findCategory(cat).findItem(choice).setPrice(String.valueOf(Functions.toAmount(newPrice)));
					}
					itemNameField.setText("");
					itemPriceField.setText("");
					resetItemList(cat);

				}
			}
			else if(newName.equals(""))
				//fix description, price
			{
				if(!Functions.isMoney(newPrice))
					JOptionPane.showMessageDialog(null,"ERROR: Invalid Price");
				else 
				{	
					if (cat !=null && choice != null){
						newCategory.findCategory(cat).findItem(choice).setDescription(newDescription);
						newCategory.findCategory(cat).findItem(choice).setPrice(String.valueOf(Functions.toAmount(newPrice)));
					}
					itemDescriptionField.setText("");
					itemPriceField.setText("");
					resetItemList(cat);

				}
			}
			else
				//fix name, price,description
			{
				if(!Functions.isMoney(newPrice))
					JOptionPane.showMessageDialog(null,"ERROR: Invalid Price");
				else 
				{
					if(cat !=null && choice != null){
						newCategory.findCategory(cat).findItem(choice).setPrice(String.valueOf(Functions.toAmount(newPrice)));
						newCategory.findCategory(cat).findItem(choice).setName(newName);
						newCategory.findCategory(cat).findItem(choice).setDescription(newDescription);
					}
					itemDescriptionField.setText("");
					itemNameField.setText("");
					itemPriceField.setText("");
					resetItemList(cat);
				}
			}
		}
		Functions.update(this);
		saveArrays();
	}
	/**
	 * Resets both lists to represent modified item and category information.  Called after any user changes are
	 * made.
	 */
	private void resetLists()
	{
		categoryModel.removeAllElements();
		itemModel.removeAllElements();
		//Category newCategory = categorys;
		LinkedList  node = categorys.getfirst();
		while (node != null) {
			categoryModel.addElement(node.getCategoryName());
			node = node.getCategoryLink();
		}
		
		categoryLabel.setText("Select a Category (" + categoryModel.getSize() + "/" +categoryModel.getSize()+")");
	}
	/**
	 * Resets only the item list to represent newly modified item information
	 * @param catIndex item category which needs to refreshed
	 */
	private void resetItemList(String catName)
	{
		Category newCategory = categorys;
		LinkedList  cat= newCategory.findCategory(catName);
		LinkedListNode item= cat.getFirstItem();
		itemModel.removeAllElements();
		while (item != null) {
			itemModel.addElement(Functions.toMoney(item.getPrice())+ "     "
															+item.getName()+"     "+item.getDescription());
			item =item.getlink();
		}
		
		itemLabel.setText("Select an Item (" + itemModel.getSize() +"/"+itemModel.getSize()+")");
	}
	/**
	 * Reads the saved item and category information into the program from the system.  Item and category
	 * information is saved in serialized arrays.
	 */
	private void readArrays()
	{
		ObjectInputStream readCategory = null;
		
		try
		{
		
			readCategory = new ObjectInputStream(new FileInputStream (CATEGORY_LIST));
			categorys = (Category) readCategory.readObject();

			readCategory.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"ERROR: Arrays Not Loaded Correctly");
		}
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"ERROR: Local Array Class Not Found");
		}
	}
	/**
	 * Saves modified item and category data to the system in the form of serialized arrays.
	 */
	private void saveArrays()
	{
		
		ObjectOutputStream saveObject = null;
		try
		{
			saveObject = new ObjectOutputStream (new FileOutputStream (CATEGORY_LIST));
						
			saveObject.writeObject(categorys);
			saveObject.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"ERROR: Arrays Not Saved Correctly");
		}
	}
}
