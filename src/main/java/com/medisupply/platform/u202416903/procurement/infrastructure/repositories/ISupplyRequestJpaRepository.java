package com.medisupply.platform.u202416903.procurement.infrastructure.repositories;

import com.medisupply.platform.u202416903.procurement.infrastructure.entities.SupplyRequestPersistenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRequestJpaRepository extends JpaRepository<SupplyRequestPersistenceEntity, Long> {

}
