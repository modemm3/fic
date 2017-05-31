package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.TypePersonDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.TypePerson;

@BuilderConfiguration (dtoClass = TypePersonDTO.class, entityClass= TypePerson.class)
public class TypePersonBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		return null;
	}

}
