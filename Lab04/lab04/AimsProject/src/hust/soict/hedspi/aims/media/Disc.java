package hust.soict.hedspi.aims.media;

public class Disc extends Media{
	private int length;
	String director;
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Disc(String title, String category,float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Disc(String title, String category, String director, int length,float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
		// TODO Auto-generated constructor stub
	}
	public Disc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public void setLength(int length) {
		this.length = length;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String toString() {
		String resultString = new String();
		resultString = String.format("Disc - %-25s - %-20s - %-15s - %3d : %8.2f $ ", this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
		return resultString;
	}
}
