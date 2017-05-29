package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.MovementTypeDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.MovementType;

@BuilderConfiguration (dtoClass= MovementTypeDTO.class, entityClass= MovementType.class)
public class MovementTypeBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final MovementTypeDTO movementTypeDTO = new MovementTypeDTO();
		final MovementType movementType = (MovementType) entity;
		
		
		movementTypeDTO.setDescription(movementType.getDescription());
		movementTypeDTO.setName(movementType.getName());
		movementTypeDTO.setId(movementType.getId());
		
		if(movementType.getCompany() != null){
			movementTypeDTO.setCompanyId(movementType.getCompany().getId());
		}
		
		if(movementType.getMovementConcept() != null){
			movementTypeDTO.setMovementConceptId(movementType.getMovementConcept().getId());
		}
		
		if(movementType.getStatus() != null){
			movementTypeDTO.setStatusId(movementType.getStatus().getId());
		}
		
		return movementTypeDTO;
	}

}
