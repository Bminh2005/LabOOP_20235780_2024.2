package hust.soict.hedspi.test.store;


import java.util.ArrayList;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon Special MOVIE", "Anime", "Fuijo. F.", 128, 10.0f);
		CompactDisc disc = new CompactDisc("Flow", "MUSIC", 12.0f);
		Book book1 = new Book("Mat Biec", "Tinh Cam", 11.0f);
		Store store = new Store();
		store.addMedia(book1);
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(disc);
		ArrayList<Media> list = store.getItemsInStore();
		for(Media m: list) {
			System.out.println(m.toString());
		}
		
	}
}
