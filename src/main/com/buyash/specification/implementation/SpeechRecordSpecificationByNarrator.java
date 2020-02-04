package com.buyash.specification.implementation;

import com.buyash.entity.AudioRecord;
import com.buyash.entity.SpeechRecord;
import com.buyash.specification.Specification;

public class SpeechRecordSpecificationByNarrator implements Specification {

    private String narrator;

    public SpeechRecordSpecificationByNarrator(String narrator) {
        this.narrator = narrator;
    }

    @Override
    public boolean specified(AudioRecord audioRecord) {
        return audioRecord.getClass() == SpeechRecord.class
                && ((SpeechRecord) audioRecord).getNarrator().equals(narrator);
    }
}
