package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
	public static void main(String args[]) {
		CompactDisc disc = new CompactDisc("ABC");
		Store eleven7 = new Store();
		eleven7.addMedia(disc);
		eleven7.addMedia(disc);
	}
}
