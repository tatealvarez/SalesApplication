
public class SalesItem {
	private String name;
	private double cost;
	private int quantity;
	
	
	//constructor
	public SalesItem(String item, double cost, int n) {
		this.name = item;
		this.cost = cost;
		this.quantity = n;
		
	}

	//setters and getters for all data members
	public String getItem() {
		return name;
	}

	public void setItem(String item) {
		this.name = item;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//convert data members into single string
	public String toString() {
		return " "+ name + " \t$  " + cost + "\t" + quantity;
	}
	
	//multiply cost by quantity to get total cost of single item
	public double getTotalCost() {
		return cost * quantity;
	}
	
	
}
