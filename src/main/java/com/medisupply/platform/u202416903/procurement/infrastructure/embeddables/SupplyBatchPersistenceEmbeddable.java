package com.medisupply.platform.u202416903.procurement.infrastructure.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SupplyBatchPersistenceEmbeddable {
    @Column(name = "quantity", nullable = false, updatable = true)
    private Integer quantity;

    @Column(name = "unit", nullable = false, updatable = true)
    private String unit;
}
