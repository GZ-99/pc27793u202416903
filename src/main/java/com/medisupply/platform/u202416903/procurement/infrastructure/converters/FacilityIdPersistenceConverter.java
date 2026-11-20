package com.medisupply.platform.u202416903.procurement.infrastructure.converters;

import com.medisupply.platform.u202416903.procurement.domain.model.valueobjects.FacilityId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class FacilityIdPersistenceConverter implements AttributeConverter<FacilityId, String> {
    @Override
    public String convertToDatabaseColumn(FacilityId attribute) {
        return attribute == null ? null : attribute.value();
    }

    @Override
    public FacilityId convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new FacilityId(dbData);
    }
}
