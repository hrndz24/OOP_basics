package com.buyash.entity;

import java.math.BigDecimal;

public class SpeechRecord extends AudioRecord {

    private String narrator;

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

        if (this.getTitle() == null) {
            if (other.getTitle() != null) {
                return false;
            }
        } else {
            if (!this.getTitle().equals(other.getTitle())) {
                return false;
            }
        }

        if (this.getLengthInMilliseconds() != other.getLengthInMilliseconds()) {
            return false;
        }

        if (this.getSizeInMegabytes() == null) {
            if (other.getSizeInMegabytes() != null) {
                return false;
            }
        } else {
            if (!this.getSizeInMegabytes().equals(other.getSizeInMegabytes())) {
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
        result = prime * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = prime * result + (getSizeInMegabytes() != null ? getSizeInMegabytes().hashCode() : 0);
        result = (prime * result + getLengthInMilliseconds());
        result = prime * result + (narrator != null ? narrator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "|narrator: " + narrator;
    }
}
