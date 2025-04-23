package hust.soict.hedspi.test.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.*;
public class CartTest {
	public static void main (String[] args) {
		Cart myOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		CompactDisc dvd3 = new CompactDisc("Aladin", "Animation", 18.99f);
		CompactDisc disc3 = new CompactDisc("Aladin", "Animation", 2.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon Special MOVIE", "Anime", "Fuijo. F.", 128, 10.0f);
		Book book1 = new Book("Mat Biec", "Tinh cam", 10.0f);
		book1.addAuthor("Nguyen Nhat Anh");
		myOrder.addMedia(dvd1);
		myOrder.addMedia(dvd4);
		myOrder.addMedia(dvd2);
		myOrder.addMedia(dvd3);
		myOrder.addMedia(dvd4);
		myOrder.addMedia(book1);
		myOrder.addMedia(disc3);
		myOrder.print();
		
		ArrayList<Media> list = myOrder.getItemsOrdered();
		list.sort(Media.COMPARE_BY_TITLE_COST);
		for(Media m: list) {
			System.out.println(m.toString());
		}
		
		list.sort(Media.COMPARE_BY_COST_TITLE);
		for(Media m: list) {
			System.out.println(m.toString());
		}
		//myOrder.searchById();
		//myOrder.searchByTitle();
	}
}
