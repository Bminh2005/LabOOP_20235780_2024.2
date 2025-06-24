package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private Scanner input = new Scanner(System.in);
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public Cart() {
		super();
	}
	public void addMedia (Media media) {
		if(itemsOrdered.size() + 1 <= MAX_NUMBERS_ORDERED) {
			this.itemsOrdered.add(media);
			System.out.println("The disc \""+ media.getTitle()+"\" has been added into your cart");
		}
		else {
			System.out.println("The cart is almost full");
			System.out.println("Adding disc into your cart is FAIL!");
		}
	}
	public void addMedia (Media[] media) {
		for (int i = 0; i < media.length; i++) {
			addMedia (media[i]);
		}
	}
	public void addMedia (Media media1, Media media2) {
		addMedia(media1);
		addMedia(media2);
	}
	public boolean removeMedia (Media media) {
		for(int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).equals(media)) {
				itemsOrdered.remove(i);
				System.out.println("One disc \"" + media.getTitle() + "\" has been removed from your cart");
				return true;
			}
		}
		System.out.println("Disc \""+ media.getTitle()+"\" is not exist in your cart");
		return false;
	}
	
	public float totalCost() {
		float total = 0;
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			total += this.itemsOrdered.get(i).getCost();
		}
		return total;
	}
	
	public void printTotalCost() {
		System.out.println("TOTAL COST: $" + this.totalCost());
	}
	
	public void print() {
		System.out.println("*********************************************CART**********************************************");
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.printf("%2d. %s\n", i + 1, this.itemsOrdered.get(i).toString());
		}
		System.out.printf("%s $%4.2f\n", "Total Cost:", this.totalCost());
		System.out.println("***********************************************************************************************");
	}
	public void searchById(int i) {
		int id = input.nextInt();
		this.searchDVDs(id);
		input.nextLine();
	}
	
	public void searchByTitle() {
		String keyword;
		keyword = input.nextLine();
		this.searchDVDs(keyword);
	}
	
	
	public ObservableList<Media> searchDVDs(int id) {
		ObservableList<Media> list = FXCollections.observableArrayList();
		int countResult = 0;
		int result = -1;
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			if(this.itemsOrdered.get(i).getId() == id) {
				countResult++;
				list.add(this.itemsOrdered.get(i));
				result = i;
			}
		}
		if(result == -1) {
			System.out.println("Not found in your cart");
		}
		else {
			System.out.println("We searched " + countResult + ((countResult<=1)?" DVD:":" DVDs:"));
			System.out.println(this.itemsOrdered.get(result).toString());
		}
		return list;
	}
	
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public ObservableList<Media> sortByTitle() {
		ObservableList<Media> list = this.getItemsOrdered();	
		list.sort(Media.COMPARE_BY_TITLE_COST);
		return list;
	}
	public ObservableList<Media> sortByCost() {
		ObservableList<Media> list = this.getItemsOrdered();	
		list.sort(Media.COMPARE_BY_COST_TITLE);
		return list;
	}
	public ObservableList<Media> searchDVDs(String keyword) {
		ObservableList<Media> list = FXCollections.observableArrayList();
		for(int i = 0; i < this.itemsOrdered.size(); i++) {
			if(this.itemsOrdered.get(i).isMatch(keyword)) {
				list.add(this.itemsOrdered.get(i));
			}
		}
		if(list.size() == 0) {
			System.out.println("Not found in your cart");
		}
		else {
			if(list.size() == 1) {
				System.out.println("We searched " + list.size() + " DVD:");
			}
			else if(list.size() >1){
				System.out.println("We searched " + list.size() + " DVDs:");
			}
			
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		}
		return list;
	}
	
}
