package com.buyash.constants;

public enum StringConstant {

    SPEECH_RECORDS_FILE("src/main/resources/records/speech_records.txt"),
    SONGS_FILE("src/main/resources/records/songs.txt"),
    TRACKS_FILE("src/main/resources/records/tracks.txt"),
    DELIMITER("\\|");


    private String value;

    StringConstant(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

