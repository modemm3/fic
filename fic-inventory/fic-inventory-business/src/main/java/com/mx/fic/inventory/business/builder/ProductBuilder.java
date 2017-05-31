package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Product;

@BuilderConfiguration(dtoClass= ProductDTO.class, entityClass= Product.class)
public class ProductBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final ProductDTO productDTO = new ProductDTO();
		final Product product = (Product)entity;
		
		productDTO.setBarCode(product.getBarcode());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setId(product.getId());
		productDTO.setMaximumStock(product.getMaximumStock());
		productDTO.setMinimunStock(product.getMinimumStock());
		
		if(product.getCompany()!=null){
			productDTO.setCompanyId(product.getCompany().getId());
		}
		
		if(product.getMeasureUnit()!=null){
			productDTO.setMeasureUnitId(product.getMeasureUnit().getId());
		}
		
		if(product.getStatus()!=null){
			productDTO.setStatusId(product.getStatus().getId());
		}
		
		return productDTO;
	}

}
