package java.com.buyash.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AudioRecord implements Serializable {
    private int lengthInSeconds;
    private String title;
    private BigDecimal size;

    public AudioRecord() {
    }

    public AudioRecord(int lengthInSeconds, String title, BigDecimal size) {
        this.lengthInSeconds = lengthInSeconds;
        this.title = title;
        this.size = size.setScale(2, RoundingMode.HALF_UP);
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "length: " + lengthInSeconds + "|title: " + title + "|size: " + size;
    }
}
