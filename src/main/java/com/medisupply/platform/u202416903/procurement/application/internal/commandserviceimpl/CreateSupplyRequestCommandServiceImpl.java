package com.medisupply.platform.u202416903.procurement.application.internal.commandserviceimpl;

import com.medisupply.platform.u202416903.procurement.application.commands.CreateSupplyRequestCommand;
import com.medisupply.platform.u202416903.procurement.application.commandservices.CreateSupplyRequestCommandService;
import com.medisupply.platform.u202416903.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.FacilityId;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.RequestCode;
import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.SupplyRequestStatus;
import com.medisupply.platform.u202416903.procurement.domain.repositories.ISupplyRequestRepository;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.FulfillmentPeriod;
import com.medisupply.platform.u202416903.shared.domain.model.valueobjects.SupplyBatch;
import org.springframework.stereotype.Service;

@Service
public class CreateSupplyRequestCommandServiceImpl implements CreateSupplyRequestCommandService {
    private final ISupplyRequestRepository supplyRequestRepository;
    public CreateSupplyRequestCommandServiceImpl(ISupplyRequestRepository supplyRequestRepository) {
        this.supplyRequestRepository = supplyRequestRepository;
    }

    @Override
    public SupplyRequest handle(CreateSupplyRequestCommand command) {
        SupplyRequest supplyRequest = new SupplyRequest(
                new RequestCode(command.requestCode()),
                new FacilityId(command.facilityId()),
                new FulfillmentPeriod(
                        command.fulfillmentPeriodStartDate(),
                        command.fulfillmentPeriodEndDate()),
                new SupplyBatch(
                        command.supplyBatchQuantity(),
                        command.supplyBatchUnit()),
                command.urgencyLevel(),
                SupplyRequestStatus.fromString(command.status()),
                command.requestNotes()
        );
        return supplyRequestRepository.save(supplyRequest);
    }
}
