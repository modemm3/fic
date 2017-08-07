package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.OperationMasterDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.OperationMaster;

@BuilderConfiguration (dtoClass=OperationMasterDTO.class, entityClass=OperationMaster.class)
public class OperationMasterBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final OperationMasterDTO operationMasterDTO= new OperationMasterDTO();
		final OperationMaster operationMaster = (OperationMaster) entity;
		
		operationMasterDTO.setCompanyId(operationMaster.getCompany().getId());
		operationMasterDTO.setFolioDocument(operationMaster.getFolioDocument());
		operationMasterDTO.setId(operationMaster.getId());
		operationMasterDTO.setMovementTypeId(operationMaster.getMovementType().getId());
		operationMasterDTO.setOperationDate(operationMaster.getOperationDate().getTime());
		operationMasterDTO.setStatusId(operationMaster.getStatus().getId());
		operationMasterDTO.setCreationDate(operationMaster.getCreationDate().getTime());
		operationMasterDTO.setModificationDate(operationMaster.getModificationDate().getTime());
		
		return operationMasterDTO;
	}

}
