package com.buyash.factory.abstractfactory;

import com.buyash.parser.AudioRecordParser;
import com.buyash.reader.AudioRecordReader;

public interface AudioRecordFactory {

    AudioRecordReader getRecordReader();

    AudioRecordParser getRecordParser();
}
