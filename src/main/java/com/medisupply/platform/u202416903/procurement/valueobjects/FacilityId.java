package com.medisupply.platform.u202416903.procurement.valueobjects;

public record FacilityId(String value) {
    private static final String NOT_BLANK_MESSAGE_KEY = "procurement.error.facilityId.notBlank";

    public FacilityId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK_MESSAGE_KEY);
        }
    }
}
