package java.com.buyash.comparator;


import java.com.buyash.entity.Track;
import java.util.Comparator;

public class ComparatorByStyle implements Comparator<Track> {

    @Override
    public int compare(Track o1, Track o2) {
        return o1.getStyle().compareTo(o2.getStyle());
    }
}
