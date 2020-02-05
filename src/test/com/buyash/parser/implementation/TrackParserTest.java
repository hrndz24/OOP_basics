package com.buyash.parser.implementation;

import com.buyash.entity.Instrument;
import com.buyash.entity.Style;
import com.buyash.entity.Track;
import com.buyash.exception.ParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TrackParserTest {

    private TrackParser trackParser;

    @Before
    public void initParser() {
        trackParser = new TrackParser();
    }

    @Test
    public void parseLineToRecordPositiveTest() throws ParserException {
        String line = "328200|Is she with you|12.45|PIANO|Hans Zimmer & Junkie XL|ELECTRONIC";
        Track expected = new Track(328200, "Is she with you", BigDecimal.valueOf(12.45),
                Instrument.PIANO, "Hans Zimmer & Junkie XL", Style.ELECTRONIC);
        Assert.assertEquals(expected, trackParser.parseLineToRecord(line));
    }

    @Test(expected = ParserException.class)
    public void parseLineToRecordNegativeCase() throws ParserException {
        String line = "328200|Is she with you|12.45|Hans Zimmer & Junkie XL|ELECTRONIC";
        Track expected = new Track(328200, "Is she with you", BigDecimal.valueOf(12.45),
                Instrument.PIANO, "Hans Zimmer & Junkie XL", Style.ELECTRONIC);
        trackParser.parseLineToRecord(line);
    }

}