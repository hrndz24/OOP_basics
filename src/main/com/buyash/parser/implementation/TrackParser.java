package com.buyash.parser.implementation;

import com.buyash.constants.IntegerConstant;
import com.buyash.constants.StringConstant;
import com.buyash.entity.AudioRecord;
import com.buyash.entity.Instrument;
import com.buyash.entity.Style;
import com.buyash.entity.Track;
import com.buyash.exception.ParserException;
import com.buyash.parser.AudioRecordParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class TrackParser implements AudioRecordParser {
    private static final String TRACK_REGEX =
            "\\d+\\|.[^|]+\\|\\d+\\.\\d{1,2}\\|[A-Z_]+\\|.[^|]+\\|[A-Z_]+";
    private static Logger logger = LogManager.getLogger();

    @Override
    public AudioRecord parseLineToRecord(String line) throws ParserException {
        if (!Pattern.matches(TRACK_REGEX, line)) {
            logger.warn("Impossible to parse line into track");
            throw new ParserException("Impossible to parse line into track");
        }
        String[] trackInfo = line.split(StringConstant.DELIMITER.getValue());

        int length = Integer.parseInt(trackInfo[IntegerConstant.LENGTH_POSITION.getValue()]);
        String title = trackInfo[IntegerConstant.TITLE_POSITION.getValue()];
        BigDecimal size = BigDecimal.valueOf(Double.parseDouble(trackInfo[IntegerConstant.SIZE_POSITION.getValue()]));
        Instrument instrument = Instrument.valueOf(trackInfo[IntegerConstant.INSTRUMENT_POSITION.getValue()]);
        String composer = trackInfo[IntegerConstant.COMPOSER_POSITION.getValue()];
        Style style = Style.valueOf(trackInfo[IntegerConstant.STYLE_POSITION.getValue()]);

        Track track = new Track();
        track.setLengthInMilliseconds(length);
        track.setTitle(title);
        track.setSizeInMegabytes(size);
        track.setInstrument(instrument);
        track.setComposer(composer);
        track.setStyle(style);

        return track;
    }
}
