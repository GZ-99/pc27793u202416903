package com.medisupply.platform.u202416903.procurement.application.commandservices;

import com.medisupply.platform.u202416903.procurement.application.commands.CreateSupplyRequestCommand;
import com.medisupply.platform.u202416903.procurement.domain.model.aggregates.SupplyRequest;

public interface CreateSupplyRequestCommandService {
    SupplyRequest handle(CreateSupplyRequestCommand command);
}
