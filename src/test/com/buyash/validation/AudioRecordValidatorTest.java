package com.buyash.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AudioRecordValidatorTest {

    private AudioRecordValidator audioRecordValidator;
    @Before
    public void initValidator(){
        audioRecordValidator = new AudioRecordValidator();
    }

    @Test
    public void isPositiveLengthPositiveCase() {
        int length = 548000;
        Assert.assertTrue(audioRecordValidator.isPositiveLength(length));
    }

    @Test
    public void isPositiveLengthNegativeCase() {
        int length = -548000;
        Assert.assertFalse(audioRecordValidator.isPositiveLength(length));
    }

    @Test
    public void hasTitlePositiveCase() {
        String title = "Another level";
        Assert.assertTrue(new AudioRecordValidator().hasTitle(title));
    }

    @Test
    public void hasTitleNullTitle() {
        Assert.assertFalse(new AudioRecordValidator().hasTitle(null));
    }

    @Test
    public void hasTitleEmptyTitle() {
        String title = "";
        Assert.assertFalse(new AudioRecordValidator().hasTitle(title));
    }

    @Test
    public void isPositiveSizePositiveCase() {
        BigDecimal size = BigDecimal.valueOf(34.67);
        Assert.assertTrue(audioRecordValidator.isPositiveSize(size));
    }

    @Test
    public void isPositiveSizeNegativeCase() {
        BigDecimal size = BigDecimal.valueOf(-34.67);
        Assert.assertFalse(audioRecordValidator.isPositiveSize(size));
    }
}