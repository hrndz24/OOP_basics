package com.buyash.parser;

import com.buyash.entity.AudioRecord;
import com.buyash.exception.ParserException;

public interface AudioRecordParser {

    AudioRecord parseLineToRecord(String line) throws ParserException;
}
