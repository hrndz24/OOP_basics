package com.buyash.validation;

public class SpeechRecordValidator extends AudioRecordValidator {

    public boolean hasNarrator(String narrator) {
        return !(narrator == null || narrator.isEmpty());
    }
}
