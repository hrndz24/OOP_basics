package com.buyash.parser.implementation;

import com.buyash.entity.SpeechRecord;
import com.buyash.exception.ParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SpeechRecordParserTest {

    private SpeechRecordParser speechRecordParser;

    @Before
    public void initParser() {
        speechRecordParser = new SpeechRecordParser();
    }

    @Test
    public void parseLineToRecordPositiveCase() throws ParserException {
        String line = "2300000|I have a dream|22.87|Martin Luther King Jr.";
        SpeechRecord expected = new SpeechRecord(2300000, "I have a dream",
                BigDecimal.valueOf(22.87), "Martin Luther King Jr.");
        Assert.assertEquals(expected, speechRecordParser.parseLineToRecord(line));
    }

    @Test(expected = ParserException.class)
    public void parseLineToRecordNegativeCase() throws ParserException {
        String line = "2300000|I have a dream|-22.87|Martin Luther King Jr.";
        SpeechRecord expected = new SpeechRecord(2300000, "I have a dream",
                BigDecimal.valueOf(22.87), "Martin Luther King Jr.");
        speechRecordParser.parseLineToRecord(line);
    }
}