package com.medisupply.platform.u202416903.procurement.interfaces.controllers;

import com.medisupply.platform.u202416903.procurement.application.commands.CreateSupplyRequestCommand;
import com.medisupply.platform.u202416903.procurement.application.commandservices.CreateSupplyRequestCommandService;
import com.medisupply.platform.u202416903.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202416903.procurement.interfaces.resources.SupplyRequestRequestResource;
import com.medisupply.platform.u202416903.procurement.interfaces.resources.SupplyRequestResponseResource;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/supply-requests")
public class SupplyRequestController {
    private final CreateSupplyRequestCommandService createSupplyRequestCommandService;
    public SupplyRequestController(CreateSupplyRequestCommandService createSupplyRequestCommandService) {
        this.createSupplyRequestCommandService = createSupplyRequestCommandService;
    }

    @PostMapping
    public ResponseEntity<SupplyRequestResponseResource> createSupplyRequest
            (@Valid @RequestBody SupplyRequestRequestResource resource) {
        var command = new CreateSupplyRequestCommand(
                resource.requestCode(),
                resource.facilityId(),
                resource.fulfillmentPeriodStartDate(),
                resource.fulfillmentPeriodEndDate(),
                resource.supplyBatchQuantity(),
                resource.supplyBatchUnit(),
                resource.urgencyLevel(),
                resource.status(),
                resource.requestNotes()
        );

        SupplyRequest supplyRequest = createSupplyRequestCommandService.handle(command);

        var response = new SupplyRequestResponseResource(
                supplyRequest.getRequestCode().value(),
                supplyRequest.getFacilityId().value(),
                supplyRequest.getFulfillmentPeriod().startDate(),
                supplyRequest.getFulfillmentPeriod().endDate(),
                supplyRequest.getSupplyBatch().quantity(),
                supplyRequest.getSupplyBatch().unit(),
                supplyRequest.getUrgencyLevel(),
                supplyRequest.getStatus().toString(),
                supplyRequest.getRequestNotes()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
