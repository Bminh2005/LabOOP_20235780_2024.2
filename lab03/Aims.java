package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
	public static void main (String arg[]) {
		Cart myOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon Special MOVIE", "Anime", "Fuijo. F.", 128, 10.0f);
		
		DigitalVideoDisc combo[] = {dvd1, dvd3};
		
		myOrder.addMedia(dvd1);
		myOrder.addMedia(dvd4);
		myOrder.addMedia(dvd2);
		myOrder.addMedia(dvd3);
		myOrder.addMedia(dvd4);
		myOrder.removeMedia(dvd4);
		myOrder.addMedia(combo);
		myOrder.addMedia(dvd2, dvd4);
		myOrder.print();
		myOrder.printTotalCost();
	}
}
