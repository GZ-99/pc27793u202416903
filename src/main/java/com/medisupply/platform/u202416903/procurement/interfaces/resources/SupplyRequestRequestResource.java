package com.medisupply.platform.u202416903.procurement.interfaces.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SupplyRequestRequestResource(
        @NotNull(message = "Request Code is required")
        @NotBlank(message = "Request Code is required")
        String requestCode,

        @NotNull(message = "Facility Id is required")
        @NotBlank(message = "Facility Id is required")
        String facilityId,

        @NotNull(message = "Start Date is required")
        @NotBlank(message = "Start Date is required")
        LocalDate fulfillmentPeriodStartDate,

        @NotNull(message = "End Date is required")
        @NotBlank(message = "End Date is required")
        LocalDate fulfillmentPeriodEndDate,

        @NotNull(message = "Quantity is required")
        @NotBlank(message = "Quantity is required")
        Integer supplyBatchQuantity,

        @NotNull(message = "Unit is required")
        @NotBlank(message = "Unit is required")
        String supplyBatchUnit,

        @NotNull(message = "Urgency Level is required")
        @NotBlank(message = "Urgency Level is required")
        Integer urgencyLevel,

        String status,

        String requestNotes
) {

}
