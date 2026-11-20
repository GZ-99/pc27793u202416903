package com.medisupply.platform.u202416903.procurement.infrastructure.adapters;

import com.medisupply.platform.u202416903.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202416903.procurement.domain.repositories.ISupplyRequestRepository;
import com.medisupply.platform.u202416903.procurement.infrastructure.assemblers.SupplyRequestPersistenceAssembler;
import com.medisupply.platform.u202416903.procurement.infrastructure.repositories.ISupplyRequestJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SupplyRequestPersistenceAdapter implements ISupplyRequestRepository {
    private final ISupplyRequestJpaRepository supplyRequestJpaRepository;
    public SupplyRequestPersistenceAdapter(ISupplyRequestJpaRepository supplyRequestJpaRepository) {
        this.supplyRequestJpaRepository = supplyRequestJpaRepository;
    }

    @Override
    public SupplyRequest save(SupplyRequest entity) {
        var supplyRequestEntity = SupplyRequestPersistenceAssembler.toEntity(entity);
        var supplyRequestSaved = supplyRequestJpaRepository.save(supplyRequestEntity);
        return SupplyRequestPersistenceAssembler.toDomain(supplyRequestSaved);
    }

    @Override
    public SupplyRequest update(SupplyRequest entity) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public SupplyRequest findById(Long aLong) {
        return null;
    }
}
