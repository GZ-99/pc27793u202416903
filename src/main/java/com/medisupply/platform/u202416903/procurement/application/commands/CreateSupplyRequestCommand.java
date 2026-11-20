package com.medisupply.platform.u202416903.procurement.application.commands;

import java.time.LocalDate;

public record CreateSupplyRequestCommand(
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
    public CreateSupplyRequestCommand {
        if (requestCode == null || requestCode.isBlank()) {
            throw new IllegalArgumentException("Request Code cannot be null or blank");
        }
        if (facilityId == null || facilityId.isBlank()) {
            throw new IllegalArgumentException("Facility Id cannot be null or blank");
        }
        if (fulfillmentPeriodStartDate == null) {
            throw new IllegalArgumentException
                    ("Fulfillment Period Start Date cannot be null.");
        }
        if (fulfillmentPeriodEndDate == null) {
            throw new IllegalArgumentException
                    ("Fulfillment Period End Date cannot be null.");
        }
        if (supplyBatchQuantity == null || supplyBatchQuantity < 0) {
            throw new IllegalArgumentException
                    ("Supply Batch Quantity cannot be null or less than zero.");
        }
        if (supplyBatchUnit == null || supplyBatchUnit.isBlank()) {
            throw new IllegalArgumentException
                    ("Supply Batch Unit cannot be null or blank.");
        }
        if (urgencyLevel == null || urgencyLevel < 0) {
            throw new IllegalArgumentException("Urgency Level cannot be null or less than cero");
        }
        status = status == null ? "PENDING" : status;
        if (status.isBlank()) {
            throw new IllegalArgumentException("Status cannot be blank");
        }
    }
}
