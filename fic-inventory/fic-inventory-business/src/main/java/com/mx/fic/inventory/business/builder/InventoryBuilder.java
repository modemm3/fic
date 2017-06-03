package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.InventoryDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Inventory;

@BuilderConfiguration (dtoClass= InventoryDTO.class, entityClass=Inventory.class)
public class InventoryBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final InventoryDTO inventoryDTO= new InventoryDTO();
		final ProductDTO productDTO = new ProductDTO();
		final Inventory inventory = (Inventory) entity;
		
		inventoryDTO.setId(inventory.getId());
		inventoryDTO.setModificationDate(inventory.getModificationDate());
		inventoryDTO.setCurrentStock(inventory.getCurrentStock());
		
		if(inventory.getCompany()!=null){
			inventoryDTO.setCompanyId(inventory.getCompany().getId());
		}
		
		if(inventory.getProduct()!=null){
			productDTO.setId(inventory.getProduct().getId());
			productDTO.setName(inventory.getProduct().getName());
			inventoryDTO.setProductDTO(productDTO);
		}
		
		return inventoryDTO;
	}

}
