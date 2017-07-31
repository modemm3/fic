package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.OperationsDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Operations;

@BuilderConfiguration (dtoClass= OperationsDTO.class, entityClass= Operations.class)
public class OperationsBuilder extends AbstractDTOBuilder {

	public BaseDTO createDTO(BaseEntity entity) {
		final OperationsDTO operationsDTO = new OperationsDTO();
		final ProductDTO productDTO = new ProductDTO();
		final Operations operations = (Operations) entity;
		
		if(operations.getCompany() != null){
			operationsDTO.setCompanyId(operations.getCompany().getId());
		}
		
		operationsDTO.setUnitPrice(operations.getUnitPrice());
		operationsDTO.setId(operations.getId());
		

		
		if(operations.getProduct() != null){
			productDTO.setId(operations.getProduct().getId());			
			operationsDTO.setProductDTO(productDTO);
		}
		

		
		if(operations.getStatus() != null){
			operationsDTO.setStatusId(operations.getStatus().getId());
		}
		
		operationsDTO.setStocks(operations.getStocks());
		
		if(operations.getTimeUnit() != null){
			operationsDTO.setTimeUnitId(operations.getTimeUnit().getId());
		}
		
		return operationsDTO;
	}

}
