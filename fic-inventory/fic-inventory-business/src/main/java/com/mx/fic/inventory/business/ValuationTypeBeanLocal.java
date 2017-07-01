package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ValuationTypeDTO;

@Local
public interface ValuationTypeBeanLocal {

	void save(ValuationTypeDTO valuationTypeDTO) throws PersistenceException;

	List<ValuationTypeDTO> getAll() throws PersistenceException;

}