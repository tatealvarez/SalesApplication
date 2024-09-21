import java.util.ArrayList;

public class SalesSlip {
	
	private ArrayList<SalesItem> items;
	private int size = 0;
	
	//constructor
	public SalesSlip() {
		this.items = new ArrayList<>();
	}
	
	//add items to arraylist
	public void addItem(SalesItem item) {
		items.add(item);
		size++;
	}
	
	//add cost of all items together
	public String getTotalSales() {
		double total = 0.0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getTotalCost();
		}
		StringBuilder totalCost = new StringBuilder();
		totalCost.append(String.format("%.2f", total));
		return totalCost.toString();
	}
	
	//convert items into a list of items
	public String toString() {
		String salesSlip = "";
		String label = " ITEM\tPRICE\tQUANTITY\n";
		for (int i = 0; i < items.size(); i++) {
			salesSlip += items.get(i).toString() + "\n";
		}
		return label + salesSlip.toString();
	}
	
	public int size() {
		return size;
	}
}
