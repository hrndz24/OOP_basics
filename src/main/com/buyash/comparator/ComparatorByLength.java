package com.buyash.comparator;

import com.buyash.entity.AudioRecord;

import java.util.Comparator;

public class ComparatorByLength implements Comparator<AudioRecord> {
    @Override
    public int compare(AudioRecord o1, AudioRecord o2) {
        return Integer.compare(o1.getLengthInMilliseconds(), o2.getLengthInMilliseconds());
    }
}
