package java.com.buyash.entity;

import java.math.BigDecimal;

public class Track extends AudioRecord {
    private Instrument instrument;
    private String composer;
    private Style style;

    public Track() {
    }

    public Track(int length, String title, BigDecimal size, Instrument instrument, String composer, Style style) {
        super(length, title, size);
        this.instrument = instrument;
        this.composer = composer;
        this.style = style;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = (prime * result + getLengthInSeconds());
        result = prime * result + (getSize() != null ? getSize().hashCode() : 0);
        result = prime * result + (composer != null ? composer.hashCode() : 0);
        result = prime * result + (style != null ? style.hashCode() : 0);
        result = prime * result + (instrument != null ? instrument.hashCode() : 0);
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

        Track other = (Track) obj;
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

        return true;
    }

    @Override
    public String toString() {

        return super.toString() + "|instrument: " + instrument
                + "|composer: " + composer + "|style: " + style;
    }
}
