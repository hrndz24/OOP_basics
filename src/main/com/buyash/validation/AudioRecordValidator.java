package com.buyash.validation;

import java.math.BigDecimal;

public class AudioRecordValidator {

    public boolean isPositiveLength(int length) {
        return length > 0;
    }

    public boolean hasTitle(String title) {
        return !(title == null || title.isEmpty());
    }

    public boolean isPositiveSize(BigDecimal size) {
        return size.doubleValue() > 0;
    }
}
