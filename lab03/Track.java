package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Track track = (Track) obj;
        return this.title.equals(track.getTitle()) && this.length == track.getLength();
	}
}
