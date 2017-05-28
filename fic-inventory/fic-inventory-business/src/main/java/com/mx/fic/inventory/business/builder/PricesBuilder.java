package com.mx.fic.inventory.business.builder;

import com.mx.fic.inventory.business.builder.config.AbstractDTOBuilder;
import com.mx.fic.inventory.business.builder.config.BuilderConfiguration;
import com.mx.fic.inventory.dto.BaseDTO;
import com.mx.fic.inventory.dto.PricesDTO;
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
			pricesDTO.setCompanyId(prices.getCompany().getId());
			//pricesDTO.setCompanyDTO(TransferObjectAssembler.getInstance().assembleTO(CompanyDTO.class, prices.getCompany()));
		}
		
		if(prices.getProduct()!=null){
			pricesDTO.setProductId(prices.getProduct().getId());
			//pricesDTO.setProductDTO(TransferObjectAssembler.getInstance().assembleTO(ProductDTO.class, prices.getProduct()));
		}
		
		if(prices.getSeason()!=null){
			pricesDTO.setSeasonId(prices.getSeason().getId());
			//pricesDTO.setSeasonDTO(TransferObjectAssembler.getInstance().assembleTO(SeasonDTO.class, prices.getSeason()));
		}		
		
		if(prices.getStatus()!=null){
			pricesDTO.setStatusId(prices.getStatus().getId());
			//pricesDTO.setStatusDTO(TransferObjectAssembler.getInstance().assembleTO(StatusDTO.class, prices.getStatus()));
		}
		
		if(prices.getTypePrice()!=null){
			pricesDTO.setTypePriceId(prices.getTypePrice().getId());
			//pricesDTO.setTypePriceDTO(TransferObjectAssembler.getInstance().assembleTO(TypePriceDTO.class, prices.getTypePrice()));
		}
		return pricesDTO;
	}

}
