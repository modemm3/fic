package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.CompanyDTO;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Status;

@BuilderConfiguration(dtoClass=StatusDTO.class , entityClass= Status.class)
public class StatusBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final StatusDTO statusDTO= new StatusDTO();
		final Status status= (Status)entity;
		
		statusDTO.setId(status.getId());
		statusDTO.setName(status.getName());
		statusDTO.setDescription(status.getDescription());
		if(status.getCompany()!=null){
			statusDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, status.getCompany()));
		}
		return statusDTO;
	}

}
