package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.business.builder.config.TransferObjectAssembler;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.CompanyDTO;
import com.mx.fic.inventory.dto.PricesDTO;
import com.mx.fic.inventory.dto.ProductDTO;
import com.mx.fic.inventory.dto.SeasonDTO;
import com.mx.fic.inventory.dto.StatusDTO;
import com.mx.fic.inventory.dto.TypePriceDTO;
import com.mx.fic.inventory.persistent.BaseEntity;
import com.mx.fic.inventory.persistent.Prices;

@BuilderConfiguration (dtoClass= PricesDTO.class, entityClass= Prices.class)
public class PricesBuilder extends AbstractDTOBuilder{

	public BaseDTO createDTO(BaseEntity entity) {
		final PricesDTO pricesDTO = new PricesDTO();
		final Prices prices = (Prices) entity;
		
		pricesDTO.setCreationDate(prices.getCreationDate());
		pricesDTO.setPrice(prices.getPrice());
		
		if(prices.getCompany()!=null){
			pricesDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, prices.getCompany()));
		}
		
		if(prices.getProduct()!=null){
			pricesDTO.setProductDTO(TransferObjectAssembler.getInstance().assembleTO(ProductDTO.class, prices.getProduct()));
		}
		
		if(prices.getSeason()!=null){
			pricesDTO.setSeasonDTO(TransferObjectAssembler.getInstance().assembleTO(SeasonDTO.class, prices.getSeason()));
		}		
		
		if(prices.getStatus()!=null){
			pricesDTO.setStatusDTO(TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, prices.getStatus()));
		}
		
		if(prices.getTypePrice()!=null){
			pricesDTO.setTypePriceDTO(TransferObjectAssembler.getInstance().assembleTO(TypePriceDTO.class, prices.getTypePrice()));
		}
		return pricesDTO;
	}

}
