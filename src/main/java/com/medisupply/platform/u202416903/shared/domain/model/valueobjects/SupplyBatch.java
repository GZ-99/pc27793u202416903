package com.medisupply.platform.u202416903.shared.domain.model.valueobjects;

public record SupplyBatch(Integer quantity, String unit) {
    public SupplyBatch() {
        this(0, "");
    }

    public SupplyBatch {
        if (quantity == null || quantity < 0) {
            throw new IllegalArgumentException
                    ("Quantity cannot be null or less than zero.");
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException
                    ("Unit cannot be null or blank.");
        }
    }

    public Integer addUnits(Integer additionalQuantity) {
        return quantity + additionalQuantity;
    }
}
