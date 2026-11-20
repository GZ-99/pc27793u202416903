package com.medisupply.platform.u202416903.procurement.interfaces.resources;

import java.time.LocalDate;

public record SupplyRequestResponseResource(
        String requestCode,
        String facilityId,
        LocalDate fulfillmentPeriodStartDate,
        LocalDate fulfillmentPeriodEndDate,
        Integer supplyBatchQuantity,
        String supplyBatchUnit,
        Integer urgencyLevel,
        String status,
        String requestNotes
) {

}
