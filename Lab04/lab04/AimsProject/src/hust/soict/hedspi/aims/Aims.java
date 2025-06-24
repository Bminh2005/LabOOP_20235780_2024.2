package hust.soict.hedspi.aims;

import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.manager.AddDigitalVideoDiscToStoreScreen;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	public static Stack<Object> choice = new Stack<>();
	public static Scanner input = new Scanner(System.in);
	public static Store store = new Store();
	public static Cart cart = new Cart();
	public static Media currentMedia = new Media();
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		CompactDisc dvd3 = new CompactDisc("Aladin", "Animation", 18.99f);
		CompactDisc disc3 = new CompactDisc("Aladin", "Animation", 2.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon Special MOVIE", "Anime", "Fuijo. F.", 128, 10.0f);
		Book book1 = new Book("Mat Biec", "Tinh cam", 10.0f);
		store.addMedia(book1);
		store.addMedia(dvd4);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd1);
		store.addMedia(disc3);
		//new AddDigitalVideoDiscToStoreScreen(store);
		new StoreManagerScreen(store);
		/*while(true) {
			showMenu();
			if((int)choice.pop() == 0) break;
		}
		System.out.println("Exited" + choice);
		System.out.close();
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
		int c;
		c = input.nextInt();
		choice.push(c);
		input.nextLine();
		switch(c) {
		case 0:
			break;
		case 1:
			for(Media m: store.getItemsInStore()) {
				System.out.println(m.toString());
			}
			while(true) {
				storeMenu();
				if((int)choice.pop() == 0) {
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
			int d = input.nextInt();
			input.nextLine();
			if(d == 1) {
				System.out.println("Add a media");
				System.out.print("Title: ");
				title = input.nextLine();
				System.out.print("Category: ");
				category = input.nextLine();
				System.out.print("Cost: ");
				cost = input.nextFloat();
				currentMedia = new Media(title, category, cost);
				store.addMedia(currentMedia);
			}
			else if(d == 2) {
				System.out.println("Remove a media");
				System.out.print("Title: ");
				title = input.nextLine();
				currentMedia = new Media(title);
				store.removeMedia(currentMedia);
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
				if((int)choice.pop() == 0) {
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
		int c = input.nextInt();
		choice.push(c);
		input.nextLine();
		switch(c) {
		case 0:
			break;
		case 1:
			System.out.print("Title: ");
			title = input.nextLine();
			currentMedia = store.searchByTitle(title);
			if(currentMedia == null) {
				System.out.println("The media is not exist in Store");
			}
			else {
				System.out.println(currentMedia.toString());
				while(true) {
					mediaDetailsMenu();
					if((int)choice.pop() == 0) {
						break;
					}
				}
			}
			break;
		case 2:
			System.out.print("Title: ");
			title = input.nextLine();
			currentMedia = store.searchByTitle(title);
			cart.addMedia(currentMedia);
			break;
		case 3:
			System.out.print("Title: ");
			title = input.nextLine();
			currentMedia = store.searchByTitle(title);
			
			if(currentMedia.getClass().getSimpleName().equals("DigitalVideoDisc")) {
				((DigitalVideoDisc)currentMedia).play();
			}
			else if(currentMedia.getClass().getSimpleName().equals("CompactDisc")) {
				((CompactDisc)currentMedia).play();
			}
			else {
				System.out.println("Can not play this media");
			}
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
		int c = input.nextInt();
		choice.push(c);
		input.nextLine();
		switch(c) {
		case 0:
			break;
		case 1:
			cart.addMedia(currentMedia);
			break;
		case 2:
			if(currentMedia.getClass().getSimpleName().equals("DigitalVideoDisc")) {
				((DigitalVideoDisc)currentMedia).play();
			}
			else if(currentMedia.getClass().getSimpleName().equals("CompactDisc")) {
				((CompactDisc)currentMedia).play();
			}
			else {
				System.out.println("Can not play this media");
				}
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
		int c = input.nextInt();
		choice.push(c);
		input.nextLine();
		switch(c) {
		case 0:
			break;
		case 1:
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. By id"); 
			System.out.println("2. By title"); 
			System.out.println("0. Back");
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2");
			int d = input.nextInt();
			input.nextLine();
			switch(d) {
			case 0:
				break;
			case 1:
				cart.searchById();
				break;
			case 2:
				cart.searchByTitle();
				break;
			}
			break;
		case 2:
			System.out.println("Options: "); 
			System.out.println("--------------------------------"); 
			System.out.println("1. By title"); 
			System.out.println("2. By cost"); 
			System.out.println("0. Back");
			System.out.println("--------------------------------"); 
			System.out.println("Please choose a number: 0-1-2");
			int d1 = input.nextInt();
			input.nextLine();
			switch(d1) {
			case 0:
				break;
			case 1:
				for(Media m: cart.sortByTitle()) {
					System.out.println(m.toString());
				}
				break;
			case 2:
				for(Media m: cart.sortByCost()) {
					System.out.println(m.toString());
				}
				break;
			}
			break;
		case 3:
			System.out.println("Remove the media having index: ");
			int index = input.nextInt();
			input.nextLine();
			currentMedia = cart.getItemsOrdered().get(index);
			cart.removeMedia(currentMedia);
			break;
		case 4:
			System.out.println("Play the media having index: ");
			int index1 = input.nextInt();
			input.nextLine();
			currentMedia = cart.getItemsOrdered().get(index1);
			if(currentMedia.getClass().getSimpleName().equals("DigitalVideoDisc")) {
				((DigitalVideoDisc)currentMedia).play();
			}
			else if(currentMedia.getClass().getSimpleName().equals("CompactDisc")) {
				((CompactDisc)currentMedia).play();
			}
			else {
				System.out.println("Can not play this media");
				}
			break;
		case 5:
			System.out.println("Your order is created. Let's make a new cart ^_^");
			cart = new Cart();
			break;
		}
		*/
	}
}
