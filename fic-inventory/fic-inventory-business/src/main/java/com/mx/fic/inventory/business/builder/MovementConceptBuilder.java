package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.MovementConceptDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.MovementConcept;

@BuilderConfiguration (dtoClass= MovementConceptDTO.class, entityClass= MovementConcept.class)
public class MovementConceptBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final MovementConceptDTO movementConceptDTO = new MovementConceptDTO();
		final MovementConcept movementConcept = (MovementConcept)entity;
		
		movementConceptDTO.setDescription(movementConcept.getDescription());
		movementConceptDTO.setId(movementConcept.getId());
		movementConceptDTO.setName(movementConcept.getName());
		
		if(movementConcept.getStatus()!=null){
			movementConceptDTO.setStatusId(movementConcept.getStatus().getId());
		}
		
		if(movementConcept.getCompany()!=null){
			movementConceptDTO.setCompanyId(movementConcept.getCompany().getId());
		}
		
		return movementConceptDTO;
	}
	
}
