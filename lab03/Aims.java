package hust.soict.hedspi.aims;

import java.util.Scanner;

import javax.print.attribute.standard.MediaPrintableArea;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	public static int choice;
	public static Scanner input = new Scanner(System.in);
	public static Store store = new Store();
	public static Cart cart = new Cart();
	public static void main(String[] args) {
		
		while(true) {
			showMenu();
			if(choice == 0) break;
		}
	}
	public static void showMenu () {
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3");
		choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		case 0: 
			break;
		case 1:
			for(Media m: store.getItemsInStore()) {
				System.out.println(m.toString());
			}
			while(true) {
				storeMenu();
				if(choice == 0) {
					break;
				}
			}
			break;
		case 2:
			String title, category;
			float cost;
			System.out.println("1. Add a media");
			System.out.println("2. Remove a media");
			System.out.println("0. Back");
			System.out.println("Please choose a number: 0-1-2");
			int c = input.nextInt();
			input.nextLine();
			if(c == 1) {
				System.out.println("Add a media");
				System.out.print("Title: ");
				title = input.nextLine();
				System.out.print("Category: ");
				category = input.nextLine();
				System.out.print("Cost: ");
				cost = input.nextFloat();
				Media a = new Media(title, category, cost);
				store.addMedia(a);
			}
			else if(c == 2) {
				System.out.println("Remove a media");
				System.out.print("Title: ");
				title = input.nextLine();
				Media a = new Media(title);
				store.removeMedia(a);
			}
			else {
				break;
			}
			break;
		case 3:
			for(Media m: cart.getItemsOrdered()) {
				System.out.println(m.toString());
			}
			while(true) {
				cartMenu();
				if(choice == 0) {
					break;
				}
			}
		}
	}
	public static void storeMenu() {
		
		String title;
		
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
		choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		case 0:
			break;
		case 1:
			System.out.print("Title: ");
			title = input.nextLine();
			Media a = store.searchByTitle(title);
			if(a == null) {
				System.out.println("The media is not exist in Store");
			}
			else {
				System.out.println(a.toString());
				while(true) {
					mediaDetailsMenu();
					if(choice == 0) {
						break;
					}
				}
			}
			break;
		case 2:
			System.out.print("Title: ");
			title = input.nextLine();
			Media b = store.searchByTitle(title);
			cart.addMedia(b);
			break;
		case 3:
			System.out.print("Title: ");
			title = input.nextLine();
			Media c = store.searchByTitle(title);
			DigitalVideoDisc d = (DigitalVideoDisc)c;
			d.play();
			break;
		case 4:
			cart.print();
			break;
		}
		
	}
	public static void mediaDetailsMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
		choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		}
		
	} 
	
	public static void cartMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter media in cart"); 
		System.out.println("2. Sort media in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		switch(choice) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		}
	}
}
