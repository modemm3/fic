package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.TypePriceDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.TypePrice;

@BuilderConfiguration (dtoClass= TypePriceDTO.class, entityClass= TypePrice.class)
public class TypePriceBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final TypePriceDTO typePriceDTO= new TypePriceDTO();
		final TypePrice typePrice = (TypePrice)entity;
		
		typePriceDTO.setId(typePrice.getId());
		typePriceDTO.setName(typePrice.getName());
		typePriceDTO.setDescription(typePrice.getDescription());
		
		if(typePrice.getStatus()!=null){
			typePriceDTO.setStatusId(typePrice.getStatus().getId());
			//typePriceDTO.setStatusDTO(TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, typePrice.getStatus()));
		}
		
		if(typePrice.getCompany()!=null){
			typePriceDTO.setCompanyId(typePrice.getCompany().getId());
			//typePriceDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, typePrice.getCompany()));
		}
		
		return typePriceDTO;
	}

}
