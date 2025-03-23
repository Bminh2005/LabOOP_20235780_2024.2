package main;

public class Aims {
	public static void main (String arg[]) {
		Cart myOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doraemon Special MOVIE", "Anime", "Fuijo. F.", 128, 10.0f);
		myOrder.addDigitalVideoDisc(dvd1);
		myOrder.addDigitalVideoDisc(dvd4);
		myOrder.addDigitalVideoDisc(dvd2);
		myOrder.addDigitalVideoDisc(dvd3);
		myOrder.printTotalCost();
		myOrder.addDigitalVideoDisc(dvd4);
		myOrder.printTotalCost();
		myOrder.removeDigitalVideoDisc(dvd4);
		myOrder.printTotalCost();
		
	}
}
