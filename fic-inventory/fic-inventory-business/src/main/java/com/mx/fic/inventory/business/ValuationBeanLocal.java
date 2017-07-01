package com.mx.fic.inventory.business;

import java.util.List;

import javax.ejb.Local;

import com.mx.fic.inventory.business.exception.PersistenceException;
import com.mx.fic.inventory.dto.ValuationDTO;

@Local
public interface ValuationBeanLocal {

	void saveValuation(ValuationDTO valuationDTO) throws PersistenceException;

	List<ValuationDTO> getAllByCompany(Integer companyId) throws PersistenceException;

}