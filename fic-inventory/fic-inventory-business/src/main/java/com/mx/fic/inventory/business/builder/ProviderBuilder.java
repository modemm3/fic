package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ProviderDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Provider;

@BuilderConfiguration (dtoClass= ProviderDTO.class, entityClass= Provider.class)
public class ProviderBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final ProviderDTO providerDTO = new ProviderDTO();
		final Provider provider = (Provider) entity;
		
		if(provider.getCompany() != null){
			providerDTO.setCompanyId(provider.getCompany().getId());
		}
		
		providerDTO.setEmail(provider.getEmail());
		providerDTO.setId(provider.getId());
		providerDTO.setLastName(provider.getLastName());
		providerDTO.setName(provider.getName());
		providerDTO.setReasonSocial(provider.getReasonSocial());
		providerDTO.setRfc(provider.getReasonSocial());
		
		if(provider.getStatus() != null){
			providerDTO.setStatusId(provider.getStatus().getId());
		}
		
		providerDTO.setSurName(provider.getSurName());
		
		if(provider.getTypePerson() != null){
			providerDTO.setTypePersonId(provider.getTypePerson().getId());
		}
		
		return providerDTO;
	}

}
