package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ValuationTypeDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.ValuationType;

@BuilderConfiguration (dtoClass= ValuationTypeDTO.class, entityClass= ValuationType.class)
public class ValuationTypeBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final ValuationTypeDTO valuationTypeDTO = new ValuationTypeDTO();
		final ValuationType valuationType = (ValuationType) entity;
		
		valuationTypeDTO.setId(valuationType.getId());
		valuationTypeDTO.setDescription(valuationType.getDescription());
		valuationTypeDTO.setKeyValuation(valuationType.getKeyValuation());
		valuationTypeDTO.setName(valuationType.getName());
		
		if(valuationType.getCompany()!=null){
			valuationTypeDTO.setCompanyId(valuationType.getCompany().getId());
			//valuationTypeDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, valuationType.getCompany()));
		}
		
		return valuationTypeDTO;
	}

}
