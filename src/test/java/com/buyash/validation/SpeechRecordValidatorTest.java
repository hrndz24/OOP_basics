package com.buyash.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpeechRecordValidatorTest {

    private SpeechRecordValidator speechRecordValidator;

    @Before
    public void initValidator() {
        speechRecordValidator = new SpeechRecordValidator();
    }

    @Test
    public void hasNarratorPositiveCase() {
        String narrator = "The king";
        Assert.assertTrue(speechRecordValidator.hasNarrator(narrator));
    }

    @Test
    public void hasNarratorNullNarrator() {
        Assert.assertFalse(speechRecordValidator.hasNarrator(null));
    }

    @Test
    public void hasNarratorEmptyNarrator() {
        String narrator = "";
        Assert.assertFalse(speechRecordValidator.hasNarrator(narrator));
    }
}