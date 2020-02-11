package com.buyash.specification.implementation;

import com.buyash.entity.AudioRecord;
import com.buyash.entity.Style;
import com.buyash.entity.Track;
import com.buyash.specification.Specification;

public class TrackSpecificationByStyle implements Specification {

    private Style style;

    public TrackSpecificationByStyle(Style style) {
        this.style = style;
    }

    @Override
    public boolean specified(AudioRecord audioRecord) {
        return audioRecord.getClass() == Track.class
                && ((Track) audioRecord).getStyle().equals(style);
    }
}
