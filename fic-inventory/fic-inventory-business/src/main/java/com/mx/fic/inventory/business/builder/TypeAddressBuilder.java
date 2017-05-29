package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.TypeAddressDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.TypeAddress;

@BuilderConfiguration(dtoClass= TypeAddressDTO.class, entityClass= TypeAddress.class)
public class TypeAddressBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final TypeAddressDTO typeAddressDTO = new TypeAddressDTO();
		final TypeAddress typeAddress = (TypeAddress) entity;
		
		typeAddressDTO.setDescription(typeAddress.getDescription());
		typeAddressDTO.setId(typeAddress.getId());
		typeAddressDTO.setName(typeAddress.getName());
		
		if(typeAddress.getCompany()!=null){
			typeAddressDTO.setCompanyId(typeAddress.getCompany().getId());
		}
		
		return typeAddressDTO;
	}
}
