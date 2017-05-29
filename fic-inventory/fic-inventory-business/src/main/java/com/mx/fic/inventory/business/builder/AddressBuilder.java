package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.AddressDTO;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.persistent.Address;
import com.mx.fic.inventory.persistent.BaseEntity;

@BuilderConfiguration(dtoClass= AddressDTO.class, entityClass=Address.class)
public class AddressBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final AddressDTO addressDTO = new AddressDTO();
		final Address address = (Address)entity;
		
		addressDTO.setCity(address.getCity());
		addressDTO.setColony(address.getColony());
		addressDTO.setExteriorNumber(address.getExteriorNumber());
		addressDTO.setId(address.getId());
		addressDTO.setInteriorNumber(address.getInteriorNumber());
		addressDTO.setPostalCode(address.getPostalCode());
		addressDTO.setState(address.getState());
		
		if(address.getStatus()!=null){
			addressDTO.setStatusId(address.getStatus().getId());
		}
		
		if(address.getCompany()!=null){
			addressDTO.setCompanyId(address.getCompany().getId());
		}
		
		addressDTO.setStreet(address.getStreet());
		addressDTO.setTown(address.getTown());
		
		if(address.getTypeAddress()!=null){
			addressDTO.setTypeAddressId(address.getTypeAddress().getId());
		}
		
		return addressDTO;
	}

}
