package com.medisupply.platform.u202416903.procurement.domain.model.valueobjects;

import java.util.Arrays;

public enum SupplyRequestStatus {
    PENDING(1),
    APPROVED(2),
    FULFILLED(3),
    CANCELLED(4);

    private final Integer id;

    SupplyRequestStatus(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public static SupplyRequestStatus fromValue(Integer id) {
        return Arrays.stream(SupplyRequestStatus.values())
                .filter(pr -> pr.id == id)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("[SupplyRequestStatus] Invalid value for SupplyRequestStatus: " + id));
    }

    public static SupplyRequestStatus fromString(String name) {
        return  Arrays.stream(SupplyRequestStatus.values())
                .filter(ps -> ps.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("[SupplyRequestStatus] Invalid string for SupplyRequestStatus: " + name));
    }
}
