package com.medisupply.platform.u202416903.procurement.aggregates;

import com.medisupply.platform.u202416903.procurement.valueobjects.FacilityId;
import com.medisupply.platform.u202416903.procurement.valueobjects.RequestCode;
import com.medisupply.platform.u202416903.procurement.valueobjects.SupplyRequestStatus;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.FulfillmentPeriod;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.SupplyBatch;

import java.time.Instant;

public class SupplyRequest {
    private Long id;
    private RequestCode requestCode;
    private FacilityId facilityId;
    private FulfillmentPeriod fulfillmentPeriod;
    private SupplyBatch supplyBatch;
    private Integer urgencyLevel;
    private SupplyRequestStatus status;
    private String requestNotes;
    private Instant createdAt;
    private Instant updatedAt;

    public SupplyRequest(RequestCode requestCode, FacilityId facilityId, FulfillmentPeriod fulfillmentPeriod, SupplyBatch supplyBatch, Integer urgencyLevel,
                         SupplyRequestStatus status, String requestNotes) {
        this.requestCode = requestCode;
        this.facilityId = facilityId;
        this.fulfillmentPeriod = fulfillmentPeriod;
        this.supplyBatch = supplyBatch;
        this.urgencyLevel = urgencyLevel;
        this.status = status;
        this.requestNotes = requestNotes;
    }

    public Long getId() {
        return id;
    }

    public RequestCode getRequestCode() {
        return requestCode;
    }

    public FacilityId getFacilityId() {
        return facilityId;
    }

    public FulfillmentPeriod getFulfillmentPeriod() {
        return fulfillmentPeriod;
    }

    public SupplyBatch getSupplyBatch() {
        return supplyBatch;
    }

    public Integer getUrgencyLevel() {
        return urgencyLevel;
    }

    public SupplyRequestStatus getStatus() {
        return status;
    }

    public String getRequestNotes() {
        return requestNotes;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
