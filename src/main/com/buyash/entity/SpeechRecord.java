package com.buyash.entity;

import java.math.BigDecimal;

public class SpeechRecord extends AudioRecord {

    private String narrator;

    public SpeechRecord() {
    }

    public SpeechRecord(int length, String title, BigDecimal size, String narrator) {
        super(length, title, size);
        this.narrator = narrator;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
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

        SpeechRecord other = (SpeechRecord) obj;

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

        if (this.narrator == null) {
            if (other.narrator != null) {
                return false;
            }
        } else {
            if (!this.narrator.equals(other.narrator)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (title != null ? title.hashCode() : 0);
        result = prime * result + (sizeInMegabytes != null ? sizeInMegabytes.hashCode() : 0);
        result = (prime * result + lengthInMilliseconds);
        result = prime * result + (narrator != null ? narrator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "|narrator: " + narrator;
    }
}
