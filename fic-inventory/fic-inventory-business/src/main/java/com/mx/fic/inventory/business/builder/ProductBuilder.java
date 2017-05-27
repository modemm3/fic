package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.CompanyDTO;
import com.mx.fic.inventory.dto.MeasureUnitDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Product;

@BuilderConfiguration(dtoClass= ProductDTO.class, entityClass= Product.class)
public class ProductBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final ProductDTO productDTO = new ProductDTO();
		final Product product = new Product();
		
		productDTO.setBarCode(product.getBarcode());
		if(product.getCompany()!=null){
			productDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, product.getCompany()));
		}
		productDTO.setDescription(product.getDescription());
		productDTO.setId(product.getId());
		productDTO.setMaximumStock(product.getMaximumStock());
		productDTO.setMinimunStock(product.getMinimumStock());
		if(product.getMeasure()!=null){
			productDTO.setMeasureUnitDTO(TransferObjectAssembler.getInstance().assembleTO(MeasureUnitDTO.class, product.getMeasure()));
		}
		productDTO.setName(product.getName());
		if(product.getStatus()!=null){
			productDTO.setStatusDTO(TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, product.getStatus()));
		}
		return productDTO;
	}

}
