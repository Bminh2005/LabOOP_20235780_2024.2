package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	
	
	public DigitalVideoDisc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
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

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
	
	

}
