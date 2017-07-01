package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.PricesDTO;

@Local
public interface PricesBeanLocal {

	void save(PricesDTO pricesDTO) throws PersistenceException;

	List<PricesDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}