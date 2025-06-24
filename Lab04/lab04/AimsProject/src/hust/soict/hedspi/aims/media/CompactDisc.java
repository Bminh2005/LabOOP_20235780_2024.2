package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track> ();
	public String getArtist() {
		return artist;
	} 
	
	public boolean addTrack(Track track) {
		for(int i = 0; i < tracks.size(); i++) {
			if(tracks.get(i).equals(track)) {
				System.out.println("This track is already in CompactDisc!");
				return false;
			}
		}
		System.out.println("OK! This track is added into CompactDisc");
		tracks.add(track);
		return true;
	}
	
	
	public boolean removeTrack(Track track) {
		for(int i = 0; i < tracks.size(); i++) {
			if(tracks.get(i).equals(track)) {
				tracks.remove(i);
				System.out.println("OK! This track is removed from CompactDisc");
				return true;
			}
		}
		System.out.println("NOPE! this track is not exist in CompactDisc");
		return false;
	}
	
	public int getLength() {
		int length = 0;
		for(int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		this.setLength(length);	
		return length;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for(int i = 0; i < tracks.size(); i++) {
			this.tracks.get(i).play();
		}
	}

	public CompactDisc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	
}
