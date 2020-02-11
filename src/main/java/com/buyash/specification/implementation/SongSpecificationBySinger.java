package com.buyash.specification.implementation;

import com.buyash.entity.AudioRecord;
import com.buyash.entity.Song;
import com.buyash.specification.Specification;

public class SongSpecificationBySinger implements Specification {

    private String singer;

    public SongSpecificationBySinger(String singer) {
        this.singer = singer;
    }

    @Override
    public boolean specified(AudioRecord audioRecord) {
        return audioRecord.getClass() == Song.class
                && ((Song) audioRecord).getSinger().equals(singer);
    }
}
