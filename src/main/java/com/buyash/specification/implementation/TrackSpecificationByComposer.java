package java.com.buyash.specification.implementation;

import java.com.buyash.entity.AudioRecord;
import java.com.buyash.entity.Track;
import java.com.buyash.specification.Specification;

public class TrackSpecificationByComposer implements Specification {
    private String composer;

    public TrackSpecificationByComposer(String composer) {
        this.composer = composer;
    }


    @Override
    public boolean specified(AudioRecord audioRecord) {
        return audioRecord.getClass() == Track.class
                && ((Track) audioRecord).getComposer().equals(composer);
    }
}
