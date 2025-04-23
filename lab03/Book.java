package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public boolean addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			return false;
		}
		authors.add(authorName);
		return true;
	}
	
	public boolean removeAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i++) {
			if(authors.get(i).equals(authorName)) {
				authors.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	public String toString() {
		String resultString = new String();
		resultString = String.format("Book - %-25s - %-20s - %-15s - %3d : %8.2f $ ", this.getTitle(), this.getCategory(), this.getAuthors().get(0), null, this.getCost());
		return resultString;
	}
}
