package com.medisupply.platform.u202416903.procurement.infrastructure.assemblers;

import com.medisupply.platform.u202416903.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.FacilityId;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.RequestCode;
import com.medisupply.platform.u202416903.procurement.infrastructure.entities.SupplyRequestPersistenceEntity;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.FulfillmentPeriod;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.SupplyBatch;

public class SupplyRequestPersistenceAssembler {
    public static SupplyRequest toDomain(SupplyRequestPersistenceEntity entity) {
        if (entity == null) {
            return null;
        }
        return new SupplyRequest(
                new RequestCode(entity.getRequestCode().value()),
                new FacilityId(entity.getFacilityId().value()),
                new FulfillmentPeriod(
                        entity.getFulfillmentPeriod().startDate(),
                        entity.getFulfillmentPeriod().endDate()
                ),
                new SupplyBatch(
                        entity.getSupplyBatch().quantity(),
                        entity.getSupplyBatch().unit()
                ),
                entity.getUrgencyLevel(),
                entity.getStatus(),
                entity.getRequestNotes()
        );
    }

    public static SupplyRequestPersistenceEntity toEntity(SupplyRequest supplyRequest) {
        if (supplyRequest == null) {
            return null;
        }
        return SupplyRequestPersistenceEntity.builder()
                .requestCode(new RequestCode(supplyRequest.getRequestCode().value()))
                .facilityId(new FacilityId(supplyRequest.getFacilityId().value()))
                .fulfillmentPeriod(new FulfillmentPeriod(
                        supplyRequest.getFulfillmentPeriod().startDate(),
                        supplyRequest.getFulfillmentPeriod().endDate()))
                .supplyBatch(new SupplyBatch(
                        supplyRequest.getSupplyBatch().quantity(),
                        supplyRequest.getSupplyBatch().unit()))
                .urgencyLevel(supplyRequest.getUrgencyLevel())
                .status(supplyRequest.getStatus())
                .requestNotes(supplyRequest.getRequestNotes())
                .build();
    }
}
