package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.InventoryOperationDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.InventoryOperation;

@BuilderConfiguration (dtoClass= InventoryOperationDTO.class, entityClass= InventoryOperation.class)
public class InventoryOperationBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final InventoryOperationDTO inventoryOperationDTO = new InventoryOperationDTO();
		final InventoryOperation inventoryOperation = (InventoryOperation) entity;
		
		if (inventoryOperation != null){
			inventoryOperationDTO.setId(inventoryOperation.getId());
			inventoryOperationDTO.setAmount(inventoryOperation.getAmount());
			inventoryOperationDTO.setAmountBalance(inventoryOperation.getAmountBalance());
			inventoryOperationDTO.setCompanyId(inventoryOperation.getCompanyId());
			if(inventoryOperation.getInventoryOperationRoot()!=null){
				inventoryOperationDTO.setInventoryOperationRootId(inventoryOperation.getInventoryOperationRoot().getId());
			}
			inventoryOperationDTO.setMovementConcept(inventoryOperation.getMovementConcept());
			inventoryOperationDTO.setMovementType(inventoryOperation.getMovementType());
			inventoryOperationDTO.setMovementDate(inventoryOperation.getMovementDate());
			if(inventoryOperation.getOperation()!=null){
				inventoryOperationDTO.setOperationId(inventoryOperation.getOperation().getId());
			}
			if(inventoryOperation.getProduct()!=null){
				inventoryOperationDTO.setProductId(inventoryOperation.getProduct().getId());
			}
			inventoryOperationDTO.setStatus(inventoryOperation.getStatus());
			inventoryOperationDTO.setValueUnitBalance(inventoryOperation.getValueUnitBalance());
			inventoryOperationDTO.setValueUnit(inventoryOperation.getValueUnit());
			inventoryOperationDTO.setValueTotalBalance(inventoryOperation.getValueTotalBalance());
			inventoryOperationDTO.setValueTotal(inventoryOperation.getValueTotal());
		}
		
		return inventoryOperationDTO;
	}

}
