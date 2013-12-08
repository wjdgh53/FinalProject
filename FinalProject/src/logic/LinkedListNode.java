package logic;




public class LinkedListNode implements java.io.Serializable{

	private LinkedListNode link;
	private static final long serialVersionUID = 1L;  //Added to satisfy compiler
	private String itemName;
	private String itemPrice;
	private String itemDescription;
	
	
	LinkedListNode (String newPrice, String newName, String newDescription)
	{
		itemPrice = newPrice;
		itemName = newName;
		itemDescription = newDescription;
		link = null;
	}
	/**
	 * Returns the item price
	 * @return String value representing the item price
	 */
	public String getPrice()
	{
		return itemPrice;
	}
	public String getDescription() {
		return itemDescription;
	}
	public void setDescription(String newDescription) {
		this.itemDescription = newDescription;
	}
	/**
	 * Returns the item name
	 * @return String value representing the item's name
	 */
	public String getName()
	{
		return itemName;
	}
	/**
	 * Sets the item price to a new value
	 * @param newPrice User entered String, new item price
	 */
	public void setPrice(String newPrice)
	{
		itemPrice = newPrice;
	}
	/**
	 * Sets the item name to a new value
	 * @param newName User entered String, new item name
	 */
	public void setName(String newName)
	{
		itemName = newName;
	}
	/**
	 * Changes the active state of the item object to true, adds a new name and price
	 * @param newPrice User entered item price
	 * @param newName User entered item name
	 */
	public LinkedListNode getlink () {
		return link;
	}
	public void setLink (LinkedListNode link) {
		this.link = link;
	}

}
