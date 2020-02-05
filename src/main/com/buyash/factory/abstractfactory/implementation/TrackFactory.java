package com.buyash.factory.abstractfactory.implementation;

import com.buyash.constants.StringConstant;
import com.buyash.factory.abstractfactory.AudioRecordFactory;
import com.buyash.parser.AudioRecordParser;
import com.buyash.parser.implementation.TrackParser;
import com.buyash.reader.AudioRecordReader;

public class TrackFactory implements AudioRecordFactory {

    private AudioRecordReader reader = new AudioRecordReader(StringConstant.TRACKS_FILE.getValue());
    private AudioRecordParser parser = new TrackParser();

    private static class SingletonHolder {
        private static final TrackFactory INSTANCE = new TrackFactory();
    }

    private TrackFactory() {
    }

    public static TrackFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public AudioRecordReader getRecordReader() {
        return reader;
    }

    @Override
    public AudioRecordParser getRecordParser() {
        return parser;
    }
}
