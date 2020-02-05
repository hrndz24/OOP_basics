package com.buyash.parser.implementation;

import com.buyash.entity.Instrument;
import com.buyash.entity.Song;
import com.buyash.entity.Style;
import com.buyash.exception.ParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class SongParserTest {

    private SongParser songParser;

    @Before
    public void initParser() {
        songParser = new SongParser();
    }

    @Test
    public void parseLineToRecordPositiveCase() throws ParserException {
        String line = "215400|Empire|9.12|SET_OF_INSTRUMENTS|Hollywood Undead|ROCK|Hollywood Undead";
        Song expected = new Song(215400, "Empire", BigDecimal.valueOf(9.12),
                Instrument.SET_OF_INSTRUMENTS, "Hollywood Undead", Style.ROCK, "Hollywood Undead");

        Assert.assertEquals(expected, songParser.parseLineToRecord(line));

    }

    @Test(expected = ParserException.class)
    public void parseLineToRecordNegativeCase() throws ParserException {
        String line = "-215400|Empire|9.124|SET_OF_INSTRUMENTS|Hollywood Undead|ROCK|Hollywood Undead";
        Song expected = new Song(215400, "Empire", BigDecimal.valueOf(9.12),
                Instrument.SET_OF_INSTRUMENTS, "Hollywood Undead", Style.ROCK, "Hollywood Undead");
        songParser.parseLineToRecord(line);
    }
}