package com.buyash.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrackValidatorTest {

    private TrackValidator trackValidator;
    @Before
    public void initValidator(){
        trackValidator = new TrackValidator();
    }

    @Test
    public void hasComposerPositiveCase(){
        String composer = "Hollywood Undead";
        Assert.assertTrue(trackValidator.hasComposer(composer));
    }

    @Test
    public void hasComposerNullComposer(){
        Assert.assertFalse(trackValidator.hasComposer(null));
    }

    @Test
    public void hasComposerEmptyComposer(){
        String composer = "";
        Assert.assertFalse(trackValidator.hasComposer(composer));
    }
}
