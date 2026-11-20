package com.medisupply.platform.u202416903.procurement.infrastructure.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class FulfillmentPeriodPersistenceEmbeddable {
    @Column(name = "start_date", nullable = false, updatable = true)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false, updatable = true)
    private LocalDate endDate;
}
