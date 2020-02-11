package com.buyash.entity;

import java.math.BigDecimal;

public class Song extends Track {

    private String singer;

    public Song(){}

    public Song(int length, String title, BigDecimal size, Instrument instrument, String composer, Style style, String singer) {
        super(length, title, size, instrument, composer, style);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + (singer != null ? singer.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Song other = (Song) obj;
        if (this.title == null) {
            if (other.title != null) {
                return false;
            }
        } else {
            if (!this.title.equals(other.title)) {
                return false;
            }
        }

        if (this.lengthInMilliseconds != other.lengthInMilliseconds) {
            return false;
        }

        if (this.sizeInMegabytes == null) {
            if (other.sizeInMegabytes != null) {
                return false;
            }
        } else {
            if (!this.sizeInMegabytes.equals(other.sizeInMegabytes)) {
                return false;
            }
        }

        if (this.composer == null) {
            if (other.composer != null) {
                return false;
            }
        } else {
            if (!this.composer.equals(other.composer)) {
                return false;
            }
        }

        if (this.instrument == null) {
            if (other.instrument != null) {
                return false;
            }
        } else {
            if (!this.instrument.equals(other.instrument)) {
                return false;
            }
        }

        if (this.style == null) {
            if (other.style != null) {
                return false;
            }
        } else {
            if (!this.style.equals(other.style)) {
                return false;
            }
        }

        if (this.singer == null) {
            if (other.singer != null) {
                return false;
            }
        } else {
            if (!this.singer.equals(other.singer)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "|singer: " + singer;
    }
}
