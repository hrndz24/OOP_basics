package com.buyash.factory.abstractfactory.implementation;

import com.buyash.constants.StringConstant;
import com.buyash.factory.abstractfactory.AudioRecordFactory;
import com.buyash.parser.AudioRecordParser;
import com.buyash.parser.implementation.SpeechRecordParser;
import com.buyash.reader.AudioRecordReader;

public class SpeechRecordFactory implements AudioRecordFactory {

    private AudioRecordReader reader = new AudioRecordReader(StringConstant.SPEECH_RECORDS_FILE.getValue());
    private AudioRecordParser parser = new SpeechRecordParser();

    private static class SingletonHolder {
        private static final SpeechRecordFactory INSTANCE = new SpeechRecordFactory();
    }

    private SpeechRecordFactory() {
    }

    public static SpeechRecordFactory getInstance() {
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
