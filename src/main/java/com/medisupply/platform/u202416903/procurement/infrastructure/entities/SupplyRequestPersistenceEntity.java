package com.medisupply.platform.u202416903.procurement.infrastructure.entities;

import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.FacilityId;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.RequestCode;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.SupplyRequestStatus;
import com.medisupply.platform.u202416903.procurement.infrastructure.converters.FacilityIdPersistenceConverter;
import com.medisupply.platform.u202416903.procurement.infrastructure.converters.RequestCodePersistenceConverter;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.FulfillmentPeriod;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.SupplyBatch;
import com.medisupply.platform.u202416903.shared.infrastructure.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "supply-requests")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplyRequestPersistenceEntity extends AuditableAbstractPersistenceEntity {
    @Convert(converter = RequestCodePersistenceConverter.class)
    @Column(name = "request_code", nullable = false)
    private RequestCode requestCode;

    @Convert(converter = FacilityIdPersistenceConverter.class)
    @Column(name = "facility_id", nullable = false)
    private FacilityId facilityId;

    @Embedded
    @Column(name = "fulfillment_period", nullable = false)
    private FulfillmentPeriod fulfillmentPeriod;

    @Embedded
    @Column(name = "supply_batch", nullable = false)
    private SupplyBatch supplyBatch;

    @Column(name = "urgency_level", nullable = false)
    private Integer urgencyLevel;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private SupplyRequestStatus status;

    @Column(name = "request_notes")
    private String requestNotes;
}
