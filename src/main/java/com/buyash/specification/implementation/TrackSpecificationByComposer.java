package com.buyash.specification.implementation;

import com.buyash.entity.AudioRecord;
import com.buyash.entity.Track;
import com.buyash.specification.Specification;

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
