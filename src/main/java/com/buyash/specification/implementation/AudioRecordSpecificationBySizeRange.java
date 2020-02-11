package com.buyash.specification.implementation;

import com.buyash.entity.AudioRecord;
import com.buyash.specification.Specification;

import java.math.BigDecimal;

public class AudioRecordSpecificationBySizeRange implements Specification {

    private BigDecimal minSize;
    private BigDecimal maxSize;

    public AudioRecordSpecificationBySizeRange(BigDecimal minSize, BigDecimal maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean specified(AudioRecord audioRecord) {
        double recordSize = audioRecord.getSizeInMegabytes().doubleValue();
        return recordSize >= minSize.doubleValue() && recordSize <= maxSize.doubleValue();
    }
}
