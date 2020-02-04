package com.buyash.factory.abstractfactory.implementation;

import com.buyash.constants.StringConstant;
import com.buyash.factory.abstractfactory.AudioRecordFactory;
import com.buyash.parser.AudioRecordParser;
import com.buyash.parser.implementation.SongParser;
import com.buyash.reader.AudioRecordReader;

public class SongFactory implements AudioRecordFactory {

    private AudioRecordReader reader = new AudioRecordReader(StringConstant.SONGS_FILE.getValue());
    private AudioRecordParser parser = new SongParser();

    private static class SingletonHolder {
        private static final SongFactory INSTANCE = new SongFactory();
    }

    private SongFactory(){}

    public static SongFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }

    @Override
    public AudioRecordReader getReader() {
        return reader;
    }

    @Override
    public AudioRecordParser getParser() {
        return parser;
    }
}
