package main;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[];
	private int qtyOrdered;
	
	public Cart() {
		qtyOrdered = 0;
		itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	}
	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
		if(qtyOrdered + 1 <= MAX_NUMBERS_ORDERED) {
			this.itemsOrdered[qtyOrdered] = disc;
			System.out.println("The disc \""+ disc.getTitle()+"\" has been added into your cart");
			qtyOrdered++;
		}
		else {
			System.out.println("The cart is almost full");
			System.out.println("Adding disc into your cart is FAIL!");
		}
	}
	public void addDigitalVideoDisc (DigitalVideoDisc[] disc) {
		for (int i = 0; i < disc.length; i++) {
			addDigitalVideoDisc(disc[i]);
		}
	}
	public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				for(int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered--;
				System.out.println("One disc \"" + disc.getTitle() + "\" has been removed from your cart");
				break;
			}
		}
	}
	
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += this.itemsOrdered[i].getCost();
		}
		return total;
	}
	
	public void printTotalCost() {
		System.out.println("TOTAL COST: $" + this.totalCost());
	}
	
	public void displayCart() {
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%-2d\t%-20s\t$%4.2f\n", i+1, this.itemsOrdered[i].getTitle(), this.itemsOrdered[i].getCost());
		}
		System.out.printf("%2s\t%-20s\t$%4.2f\n", "", "Total Cost", this.totalCost());
	}
}
