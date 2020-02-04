package com.buyash.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AudioRecord implements Serializable {
    private int lengthInMilliseconds;
    private String title;
    private BigDecimal sizeInMegabytes;

    public AudioRecord() {
    }

    public AudioRecord(int lengthInMilliseconds, String title, BigDecimal sizeInMegabytes) {
        this.lengthInMilliseconds = lengthInMilliseconds;
        this.title = title;
        this.sizeInMegabytes = sizeInMegabytes.setScale(2, RoundingMode.HALF_UP);
    }

    public int getLengthInMilliseconds() {
        return lengthInMilliseconds;
    }

    public void setLengthInMilliseconds(int lengthInMilliseconds) {
        this.lengthInMilliseconds = lengthInMilliseconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getSizeInMegabytes() {
        return sizeInMegabytes;
    }

    public void setSizeInMegabytes(BigDecimal sizeInMegabytes) {
        this.sizeInMegabytes = sizeInMegabytes.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "length: " + lengthInMilliseconds + "|title: " + title + "|size: " + sizeInMegabytes;
    }
}
