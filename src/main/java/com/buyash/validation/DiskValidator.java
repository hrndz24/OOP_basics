package java.com.buyash.validation;

import java.math.BigDecimal;

public class DiskValidator {

    public boolean isPositiveCapacity(BigDecimal decimal) {
        return decimal.doubleValue() > 0;
    }

    public boolean isPositiveAvailableSpace(BigDecimal availableSpace) {
        return availableSpace.doubleValue() >= 0;
    }
}
