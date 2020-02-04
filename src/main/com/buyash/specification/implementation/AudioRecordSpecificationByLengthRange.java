package com.buyash.specification.implementation;


import com.buyash.entity.AudioRecord;
import com.buyash.specification.Specification;

public class AudioRecordSpecificationByLengthRange implements Specification {

    private int minLength;
    private int maxLength;

    public AudioRecordSpecificationByLengthRange(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean specified(AudioRecord audioRecord) {
        int recordLength = audioRecord.getLengthInMilliseconds();
        return recordLength >= minLength && recordLength <= maxLength;
    }
}
