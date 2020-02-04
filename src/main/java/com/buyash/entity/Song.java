package java.com.buyash.entity;

import java.math.BigDecimal;

public class Song extends Track {

    private String singer;

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
        if (this.getTitle() == null) {
            if (other.getTitle() != null) {
                return false;
            }
        } else {
            if (!this.getTitle().equals(other.getTitle())) {
                return false;
            }
        }

        if (this.getLengthInSeconds() != other.getLengthInSeconds()) {
            return false;
        }

        if (this.getSize() == null) {
            if (other.getSize() != null) {
                return false;
            }
        } else {
            if (!this.getSize().equals(other.getSize())) {
                return false;
            }
        }

        if (this.getComposer() == null) {
            if (other.getComposer() != null) {
                return false;
            }
        } else {
            if (!this.getComposer().equals(other.getComposer())) {
                return false;
            }
        }

        if (this.getInstrument() == null) {
            if (other.getInstrument() != null) {
                return false;
            }
        } else {
            if (!this.getInstrument().equals(other.getInstrument())) {
                return false;
            }
        }

        if (this.getStyle() == null) {
            if (other.getStyle() != null) {
                return false;
            }
        } else {
            if (!this.getStyle().equals(other.getStyle())) {
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
