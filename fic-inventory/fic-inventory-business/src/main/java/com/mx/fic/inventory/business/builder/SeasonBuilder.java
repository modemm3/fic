package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.SeasonDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Season;

@BuilderConfiguration (dtoClass= SeasonDTO.class, entityClass= Season.class)
public class SeasonBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final SeasonDTO seasonDTO = new SeasonDTO();
		final Season season = (Season) entity;
		
		seasonDTO.setDescription(season.getDescription());
		seasonDTO.setEndDate(season.getEndDate());
		seasonDTO.setName(season.getName());
		seasonDTO.setStartDate(season.getStartDate());
		if(season.getCompany()!=null){
			seasonDTO.setCompanyId(season.getCompany().getId());
			//seasonDTO.setCompanydto(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, season.getCompany()));
		}
		return seasonDTO;
	}
	

}
