package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class Media {
	int id;
	String title;
	String category;
	float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	private static int nbMedias = 0;
	
	public Media() {
		super();
		this.id = Media.nbMedias;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = Media.nbMedias;
		Media.nbMedias++;
	}
	
	public Media(String title) {
		super();
		this.title = title;
		this.id = Media.nbMedias;
		Media.nbMedias++;
	}

	public String toString() {
		String resultString = new String();
		resultString = String.format("Disc - %-25s - %-20s - %-15s - %3d : %8.2f $ ", this.getTitle(), this.getCategory(), null, null, this.getCost());
		return resultString;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean isMatch(String keyword) {
		String word[] = keyword.split(" ");
		for(int i = 0; i < word.length; i++) {
			if(word[i].isEmpty()) {
				continue;
			}
			if(this.title.contains(word[i])) {
				return true;
			}
		}
		return false;
	}
	public boolean equals(Object obj) {
		if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Media media = (Media) obj;
        return this.title.equals(media.getTitle());
	}
	
}
