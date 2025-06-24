package hust.soict.hedspi.aims.media;
import java.util.Comparator;
public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		int CostCompare = 0;
		int TitleCompare = m1.getTitle().compareTo(m2.getTitle());
		float sub = m1.getCost()-m2.getCost();
		if(sub < 0) CostCompare = -1;
		else if(sub == 0) CostCompare = 0;
		else if(sub > 0) CostCompare = 1;
		return (CostCompare == 0)? TitleCompare: CostCompare;
	}
}
