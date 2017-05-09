package com.mx.fic.inventory.business.builder.config;

import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.persistent.BaseEntity;

public abstract class AbstractDTOBuilder {

	public abstract BaseDTO createDTO(final BaseEntity entity);
}
