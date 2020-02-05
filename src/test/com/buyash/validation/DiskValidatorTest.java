package com.buyash.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class DiskValidatorTest {

    private DiskValidator diskValidator;
    @Before
    public void initValidator(){
        diskValidator = new DiskValidator();
    }

    @Test
    public void isPositiveCapacityPositiveCase() {
        BigDecimal capacity = BigDecimal.valueOf(34.78);
        Assert.assertTrue(diskValidator.isPositiveCapacity(capacity));
    }

    @Test
    public void isPositiveCapacityNegativeCase() {
        BigDecimal capacity = BigDecimal.valueOf(-34.78);
        Assert.assertFalse(diskValidator.isPositiveCapacity(capacity));
    }

    @Test
    public void isPositiveAvailableSpacePositiveCase() {
        BigDecimal availableSpace = BigDecimal.valueOf(1344.78);
        Assert.assertTrue(diskValidator.isPositiveAvailableSpace(availableSpace));
    }

    @Test
    public void isPositiveAvailableSpaceNegativeCase() {
        BigDecimal availableSpace = BigDecimal.valueOf(-1344.78);
        Assert.assertFalse(diskValidator.isPositiveAvailableSpace(availableSpace));
    }
}