package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.CompanyDTO;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Company;

@BuilderConfiguration(dtoClass=CompanyDTO.class, entityClass=Company.class)
public class CompanyBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final CompanyDTO companyDTO= new CompanyDTO();
		final Company company= (Company) entity;
		
		companyDTO.setId(company.getId());
		companyDTO.setCreationDate(company.getCreationDate());
		companyDTO.setEmail(company.getEmail());
		companyDTO.setContactName(company.getContactName());
		companyDTO.setModifyDate(company.getModifyDate());
		companyDTO.setName(company.getName());
		companyDTO.setReasonSocial(company.getReasonSocial());
		companyDTO.setRfc(company.getRfc());
		if(company.getStatus()!=null){
			companyDTO.setStatusDTO(TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, company.getStatus()));
		}
		
		return companyDTO;
	}

}
