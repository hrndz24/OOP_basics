package com.buyash.constants;

public enum StringConstant {

    SPEECH_RECORDS_FILE("speech_records.txt"),
    SONGS_FILE("songs.txt"),
    TRACKS_FILE("tracks.txt"),
    DELIMITER("\\|");

    private String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

