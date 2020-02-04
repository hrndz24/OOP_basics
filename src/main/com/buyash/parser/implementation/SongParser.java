package com.buyash.parser.implementation;

import com.buyash.constants.IntegerConstant;
import com.buyash.constants.StringConstant;
import com.buyash.entity.AudioRecord;
import com.buyash.entity.Instrument;
import com.buyash.entity.Song;
import com.buyash.entity.Style;
import com.buyash.exception.ParserException;
import com.buyash.parser.AudioRecordParser;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SongParser implements AudioRecordParser {

    private static final String SONG_REGEX =
            "([0-9]+)\\|(.[^|]+)\\|([0-9]+\\.[0-9]{1,2})\\|([A-Z_]+)\\|(.[^|]+)\\|([A-Z_]+)\\|(.[^|]+)";


    @Override
    public AudioRecord parseLineToRecord(String line) throws ParserException {
        if (!Pattern.matches(SONG_REGEX, line)) {
            //todo log
            throw new ParserException("Impossible to parse line into song");
        }
        String[] songInfo = line.split(StringConstant.DELIMITER.getValue());

        int length = Integer.parseInt(songInfo[IntegerConstant.LENGTH_POSITION.getValue()]);
        String title = songInfo[IntegerConstant.TITLE_POSITION.getValue()];
        BigDecimal size = BigDecimal.valueOf(Double.parseDouble(songInfo[IntegerConstant.SIZE_POSITION.getValue()]));
        Instrument instrument = Instrument.valueOf(songInfo[IntegerConstant.INSTRUMENT_POSITION.getValue()]);
        String composer = songInfo[IntegerConstant.COMPOSER_POSITION.getValue()];
        Style style = Style.valueOf(songInfo[IntegerConstant.STYLE_POSITION.getValue()]);
        String singer = songInfo[IntegerConstant.SINGER_POSITION.getValue()];

        return new Song(length, title, size, instrument, composer, style, singer);
    }
}
