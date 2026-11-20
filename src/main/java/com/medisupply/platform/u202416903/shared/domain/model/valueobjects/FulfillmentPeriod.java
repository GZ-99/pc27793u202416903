package com.medisupply.platform.u202416903.shared.domain.model.valueobjects;

import java.time.LocalDate;

public record FulfillmentPeriod(LocalDate startDate, LocalDate endDate) {
    public FulfillmentPeriod {
        if (startDate == null) {
            throw new IllegalArgumentException
                    ("Start Date cannot be null.");
        }
        if (endDate == null) {
            throw new IllegalArgumentException
                    ("End Date cannot be null.");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException
                    ("End Date cannot be before tha Start Date.");
        }
    }

    public boolean contains(LocalDate checkDate) {
        return (checkDate.getDayOfYear() >= startDate.getDayOfYear() && checkDate.getDayOfYear() <= endDate.getDayOfYear());
    }
}
