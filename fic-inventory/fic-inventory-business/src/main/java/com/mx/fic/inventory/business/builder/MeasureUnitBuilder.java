package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.CompanyDTO;
import com.mx.fic.inventory.dto.MeasureUnitDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.MeasureUnit;

public class MeasureUnitBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final MeasureUnitDTO measureUnitDTO =new MeasureUnitDTO();
		final MeasureUnit measureUnit= (MeasureUnit) entity;
		
		measureUnitDTO.setId(measureUnit.getId());
		measureUnitDTO.setName(measureUnit.getName());
		measureUnitDTO.setDescription(measureUnit.getDescription());
		if(measureUnit.getCompany()!=null){
			measureUnitDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, measureUnit.getCompany()));
		}
		return measureUnitDTO;
	}
	

}
