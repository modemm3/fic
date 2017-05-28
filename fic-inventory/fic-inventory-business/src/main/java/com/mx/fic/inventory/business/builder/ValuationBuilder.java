package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ValuationDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Valuation;

@BuilderConfiguration (dtoClass= ValuationDTO.class, entityClass= Valuation.class)
public class ValuationBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		ValuationDTO valuationDTO= new ValuationDTO();
		Valuation valuation= (Valuation) entity;
		return null;
	}

}
