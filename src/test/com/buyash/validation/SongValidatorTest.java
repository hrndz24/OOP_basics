package com.buyash.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SongValidatorTest {

    private SongValidator songValidator;

    @Before
    public void initValidator() {
        songValidator = new SongValidator();
    }

    @Test
    public void hasSingerPositiveCase() {
        String singer = "Adelle";
        Assert.assertTrue(songValidator.hasSinger(singer));
    }

    @Test
    public void hasSingerNullSinger() {
        Assert.assertFalse(songValidator.hasSinger(null));
    }

    @Test
    public void hasSingerEmptySinger() {
        String singer = "";
        Assert.assertFalse(songValidator.hasSinger(singer));
    }
}