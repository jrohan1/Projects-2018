 

public class Item {
	private String name;
	private int price;
	private long itemId;

	public Item(String itemName, long id) {
		name = itemName;
		itemId = id;
	}
	
	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString(){
		
		String out = "Item Id: " + itemId + "\t" + name +"\tPrice: " + price;
		
		return out;
	}
}
