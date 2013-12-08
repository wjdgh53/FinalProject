package logic;




public class LinkedList implements java.io.Serializable
{
	
	private LinkedList categorylist;
	private LinkedListNode list, current, previous;
	private String categoryName;
	private int size;
	/**
	 * Initializes a category object with a system provided name and boolean value representing 
	 * whether the category is currently active.
	 * @param newName Category name
	 * @param activeState True if category is active, false if it is inactive
	 */
	LinkedList(String newName)
	{
		categoryName = newName;
		list = null;
		current = null;
		previous = null;
		categorylist = null;
		size =0;
	}
	
	/**
	 * Returns the category name.
	 * @return Category name
	 */
	public void setCategoryLink (LinkedList categorylist) {
		this.categorylist = categorylist;
	}
	public LinkedList getCategoryLink () {
		return categorylist;
	}
	public String getCategoryName()
	{
		return categoryName;
	}
	/**
	 * Sets the category name to a new String value
	 * @param newName String representing the new category name
	 */
	public void setCategoryName(String newName)
	{
		categoryName = newName;
	}
	public void addItem(String newPrice, String newName,String newDescription)
	{
		LinkedListNode newNode = new LinkedListNode(newPrice, newName, newDescription);
		if (isEmpty()) {
			list = newNode;
			current = newNode;
			previous = newNode;
			size++;
		}else if (previous.getlink() !=null) {
			current.setLink(newNode);
			previous = current;
			current = newNode;
			size++;
		}else {
			previous.setLink(newNode);
			current = newNode;
		}
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (list == null) {
			return true;
		}
		return false;
	}

	
	public void deleteItem(String name)
	{
		LinkedListNode curr  = list;
		LinkedListNode previous = list;
		boolean found = false;
		
		while (!found && curr !=null) {
			if (curr.getName().equalsIgnoreCase(name)){
				if (curr == list) {
					list = list.getlink();
					found = true;
					size--;
				}else {
					if (curr == this.previous) {
						this.previous =previous;
					}else if (this.current ==curr) {
						this.current =previous;
					}
					previous.setLink(curr.getlink());
					found = true;
					size--;
				}
			}else {
				previous = curr;
				curr = curr.getlink();
			}
		
		}
	}
	public LinkedListNode findItem(String itemName) {
		LinkedListNode curr  = list;
		boolean found = false;		
		
		while (curr != null && !found){
			if (curr.getName().equalsIgnoreCase(itemName)) {
				found = true;
			}else {
				curr = curr.getlink();
			}
			
		}
		
		return curr;
	}
	public LinkedListNode getFirstItem() {
		return list;
	}
	public int getItemSize() {
		return size;
	}
	public String toString() {
		//display items
		LinkedListNode curr = list;
		String list = "";
		while (curr != null) {
			list=list + curr.getName()+" "+ curr.getPrice();
			curr =curr.getlink();
		}
		return list;
	}

}
