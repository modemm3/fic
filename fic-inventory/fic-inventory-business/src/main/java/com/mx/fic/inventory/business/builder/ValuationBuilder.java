package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ValuationDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Valuation;

@BuilderConfiguration (dtoClass= ValuationDTO.class, entityClass= Valuation.class)
public class ValuationBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		ValuationDTO valuationDTO= new ValuationDTO();
		Valuation valuation= (Valuation) entity;
		
		valuationDTO.setDateEnd(valuation.getDateEnd());
		valuationDTO.setDateStart(valuation.getDateStart());
		valuationDTO.setExerciseFiscal(valuation.getExerciseFiscal());
		valuationDTO.setSerialId(valuation.getSerialId());
		
		if(valuation.getCompany()!=null){
			valuationDTO.setCompanyId(valuation.getCompany().getId());
			//valuationDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, valuation.getCompany()));
		}
		
		if(valuation.getStatus()!=null){
			valuationDTO.setStatusId(valuation.getStatus().getId());
			//valuationDTO.setStatusDTO(TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, valuation.getStatus()));
		}
		
		if(valuation.getValuationType()!= null){
			valuationDTO.setValuationTypeId(valuation.getValuationType().getId());
			//valuationDTO.setValuationTypeDTO(TransferObjectAssembler.getInstance().assembleTO(ValuationTypeDTO.class, valuation.getValuationType()));
		}
		
		return valuationDTO;
	}

}
