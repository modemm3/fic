package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.TypePriceDTO;

@Local
public interface TypePriceBeanLocal {

	void save(TypePriceDTO typePriceDTO) throws PersistenceException;

	List<TypePriceDTO> getAllByCompany(Integer idCompany) throws PersistenceException;
	
	boolean update(TypePriceDTO typePriceDTO) throws PersistenceException;

}