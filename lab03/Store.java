package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
public class Store {
	ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public boolean addMedia(Media media) {
		for(int i = 0; i < this.itemsInStore.size(); i++) {
			if(this.itemsInStore.get(i).equals(media)) {
				System.out.println("This media is already!");
				return false;
			}
		}
		itemsInStore.add(media);
		System.out.println("The media named \""+media.getTitle()+"\" is added into Store!");
		return true;
}
	
	public boolean removeMedia(Media media) {
		for(int i = 0; i < this.itemsInStore.size(); i++) {
			if(this.itemsInStore.get(i).equals(media)) {
				this.itemsInStore.remove(i);
				System.out.println("\"" + media.getTitle() + "\" has been removed from Store");
				return true;
			}
		}
		System.out.println("This media is not exist in Store!");
		return false;
	}
	
	
	
}
