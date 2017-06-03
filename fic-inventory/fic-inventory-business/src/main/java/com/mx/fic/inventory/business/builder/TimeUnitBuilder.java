package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.TimeUnitDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.TimeUnit;

@BuilderConfiguration (dtoClass= TimeUnitDTO.class, entityClass= TimeUnit.class)
public class TimeUnitBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final TimeUnitDTO timeUnitDTO = new TimeUnitDTO();
		final TimeUnit timeUnit = (TimeUnit) entity;
		
		timeUnitDTO.setDescription(timeUnit.getDescription());
		timeUnitDTO.setName(timeUnit.getName());
		
		if(timeUnit.getCompany()!=null){
			timeUnitDTO.setCompanyId(timeUnit.getCompany().getId());
		}
		
		return timeUnitDTO;
	}

}
