package com.medisupply.platform.u202416903.procurement.valueobjects;

public record RequestCode(String value) {
    private static final String NOT_BLANK_MESSAGE_KEY =
            "procurement.error.requestCode.notBlank";

    public RequestCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(NOT_BLANK_MESSAGE_KEY);
        }
    }
}
